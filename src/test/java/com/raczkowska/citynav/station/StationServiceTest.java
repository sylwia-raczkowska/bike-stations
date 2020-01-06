package com.raczkowska.citynav.station;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.collections.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class StationServiceTest {

	@Test
	void shouldThrowExceptionThenStationToDeleteNotExists() {
		Mockito.when(stationRepository.findById(STATION_ID_1)).thenReturn(Optional.empty());
		assertThrows(StationNotFoundException.class, () ->
			stationService.deleteStation(STATION_ID_1)
		);

	}

	@Test
	void shouldThrowExceptionThenStationToUpdateNotExists() {
		Station station = givenStation(STATION_ID_1, STATION_1);
		Mockito.when(stationRepository.findById(STATION_ID_1)).thenReturn(Optional.empty());
		assertThrows(StationNotFoundException.class, () ->
			stationService.updateStation(STATION_ID_1, station)
		);
	}

	@Test
	void shouldReturnStationsState() {
		Station station = givenStation(STATION_ID_1, STATION_1);
		int availablePositionAmount = 5;
		int occupiedPositionAmount = 2;
		int bikeAmount = 32;

		station.setPositionSet(givenPositionSet(station, availablePositionAmount, occupiedPositionAmount));
		station.setBikeSet(givenBikeSet(station, bikeAmount));
		Mockito.when(stationRepository.findAll()).thenReturn(Collections.singletonList(
			station));
		List<StationResponse> stationsState = stationService.getStationsState();

		StationResponse stationsResponse = stationsState.stream().filter(s -> s.getName().equals(station.getName())).findAny().orElse(new StationResponse());
		assertEquals(stationsResponse.getAvailablePositionAmount(), availablePositionAmount);
		assertEquals(stationsResponse.getOccupiedPositionAmount(), occupiedPositionAmount);
		assertEquals(stationsResponse.getAvailableBikesAmount(), bikeAmount);
	}

	private static final long STATION_ID_1 = 5L;
	private static final String STATION_1 = "Station1";
	private static final String STATION_2 = "Station2";

	private Station givenStation(Long id, String name) {
		Station station = Station.builder().stationId(id).name(name).build();
		station.setBikeSet(Sets.newSet(givenBike(1L, station), givenBike(2L, station)));
		return station;
	}

	private Set<Position> givenPositionSet(Station station, int availablePositionAmount, int occupiedPositionAmount) {
		Set<Position> positionSet = Sets.newSet();
		for (int i = 0; i < availablePositionAmount; i++) {
			positionSet.add(givenPosition(new Random().nextLong(), station, true));
		}

		for (int i = 0; i < occupiedPositionAmount; i++) {
			positionSet.add(givenPosition(new Random().nextLong(), station, false));
		}
		return positionSet;
	}

	private Set<Bike> givenBikeSet(Station station, int bikesAmount) {
		Set<Bike> bikeSet = Sets.newSet();
		for (int i = 0; i < bikesAmount; i++) {
			bikeSet.add(givenBike(new Random().nextLong(), station));
		}
		return bikeSet;
	}

	private Position givenPosition(Long id, Station station, boolean available) {
		return Position.builder().id(id).station(station).available(available).build();
	}

	private Bike givenBike(Long id, Station station) {
		return Bike.builder().bikeId(id).station(station).build();
	}

	@Autowired
	private StationService stationService;
	@MockBean
	private StationRepository stationRepository;
}
