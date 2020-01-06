package com.raczkowska.citynav.station;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
class StationService {
	public List<StationsResponse> getStationsState() {
		return null;
	}

	public Station createStation(Station createStation) {
		return null;
	}

	void deleteStation(Long stationId) throws StationNotFoundException {
		Station station = stationRepository.findById(stationId).orElseThrow(() -> new StationNotFoundException(stationId));
		stationRepository.delete(station);
	}

	Station updateStation(Long stationId, Station stationDetails) throws StationNotFoundException {
		Station station = stationRepository.findById(stationId).orElseThrow(() -> new StationNotFoundException(stationId));

		station.setName(stationDetails.getName());
		station.setBikeSet(stationDetails.getBikeSet());
		station.setPositionSet(stationDetails.getPositionSet());
		return stationRepository.save(station);
	}

	private final StationRepository stationRepository;
}
