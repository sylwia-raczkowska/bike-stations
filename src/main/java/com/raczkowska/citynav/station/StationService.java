package com.raczkowska.citynav.station;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
class StationService {
	List<StationResponse> getStationsState() {
		log.info("getStationsState");
		List<StationResponse> responseList = new java.util.ArrayList<>(Collections.emptyList());
		stationRepository.findAll().forEach(station -> {
				int availablePositionAmount = Math.toIntExact(
					station.getPositionSet().stream().filter(Position::isAvailable).count());
				int occupiedPositionAmount = station.getPositionSet().size() - availablePositionAmount;
				responseList.add(StationResponse.builder()
					.name(station.getName())
					.availableBikesAmount(station.getBikeSet().size())
					.availablePositionAmount(availablePositionAmount)
					.occupiedPositionAmount(occupiedPositionAmount)
					.build());
			}
		);
		log.info("Stations state={}", responseList);
		return responseList;
	}

	Station createStation(Station station) {
		log.info("createStation station={}", station);
		Station savedStation = stationRepository.save(station);
		log.info("Station saved");
		return savedStation;
	}

	void deleteStation(Long stationId) throws StationNotFoundException {
		log.info("deleteStation stationId={}", stationId);
		Station station = stationRepository.findById(stationId).orElseThrow(() -> new StationNotFoundException(stationId));
		stationRepository.delete(station);
		log.info("stationDeleted stationId={}", stationId);
	}

	Station updateStation(Long stationId, Station stationDetails) throws StationNotFoundException {
		log.info("updateStation stationId={}, stationDetails={}", stationId, stationDetails);
		Station station = stationRepository.findById(stationId).orElseThrow(() -> new StationNotFoundException(stationId));
		station.setName(stationDetails.getName());
		station.setBikeSet(stationDetails.getBikeSet());
		station.setPositionSet(stationDetails.getPositionSet());
		return stationRepository.save(station);
	}

	private final StationRepository stationRepository;
}
