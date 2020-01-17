package com.raczkowska.citynav.station;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@Slf4j
class BikeRestController {

	@PutMapping("/station/{stationId}/bike")
	public ResponseEntity addBikeToStation(@PathVariable("stationId") Long stationId, @Valid @RequestBody SaveBikeRequest bike) throws StationNotFoundException {
		log.info("Add bike {} to station {}", bike, stationId);
		bikeService.save(stationId, bike);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/station/{stationId}/bike/{bikeId}")
	public ResponseEntity rentBike(@PathVariable("stationId") Long stationId, @PathVariable("bikeId") Long bikeId) throws StationNotFoundException, BikeNotFoundException {
		log.info("Rent bike {} in station {}", bikeId, stationId);
		bikeService.rent(stationId, bikeId);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/station/bike/{bikeId}")
	public ResponseEntity returnBike(@PathVariable("bikeId") Long bikeId, @Valid @RequestBody ReturnBikeRequest returnBikeRequest) throws StationNotFoundException, BikeNotFoundException, PositionNotFoundException {
		log.info("Return bike {} to station {}", bikeId, returnBikeRequest.getStationId());
		bikeService.returnBike(bikeId, returnBikeRequest);
		return ResponseEntity.ok().build();
	}

	private final BikeService bikeService;

}
