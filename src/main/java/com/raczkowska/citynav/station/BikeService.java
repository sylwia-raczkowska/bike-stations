package com.raczkowska.citynav.station;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
class BikeService {

	void returnBike(Long bikeId, ReturnBikeRequest returnBikeRequest) throws StationNotFoundException, BikeNotFoundException, PositionNotFoundException {
		Station station = stationRepository.findById(returnBikeRequest.getStationId()).orElseThrow(StationNotFoundException::new);
		Bike bike = bikeRepository.findById(bikeId).orElseThrow(BikeNotFoundException::new);
		Position position = positionRepository.findByIdAndStationStationId(returnBikeRequest.getPositionId(), returnBikeRequest.getStationId()).orElseThrow(PositionNotFoundException::new);

		position.setAvailable(false);
		bike.setStation(station);
		bike.setPosition(position);

		stationRepository.save(station);

	}

	void rent(Long stationId, Long bikeId) throws StationNotFoundException, BikeNotFoundException {
		Station station = stationRepository.findById(stationId).orElseThrow(StationNotFoundException::new);
		Bike bike = bikeRepository.findById(bikeId).orElseThrow(BikeNotFoundException::new);

		bike.setStation(null);
		bike.getPosition().setAvailable(true);
		bike.setPosition(null);

		stationRepository.save(station);

	}

	void save(Long stationId, SaveBikeRequest bikeRequest) throws StationNotFoundException {
		Station station = stationRepository.findById(stationId).orElseThrow(StationNotFoundException::new);
		Bike bike = Bike.builder().position(Position.builder().id(bikeRequest.getPositionId()).available(false).station(station).build()).station(station).build();
		station.getBikeSet().add(bike);
		station.getPositionSet().add(bike.getPosition());
		stationRepository.save(station);
	}

	private final StationRepository stationRepository;
	private final BikeRepository bikeRepository;
	private final PositionRepository positionRepository;
}
