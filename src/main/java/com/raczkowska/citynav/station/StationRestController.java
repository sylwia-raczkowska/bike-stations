package com.raczkowska.citynav.station;

import lombok.RequiredArgsConstructor;
<<<<<<< HEAD
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
=======
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

>>>>>>> 94c5cdf... Initial commit
import java.util.List;

@RequiredArgsConstructor
@RestController
<<<<<<< HEAD
@RequestMapping("/api")
class StationRestController {

	@GetMapping("/stations")
	public List<StationResponse> stations() {
		return stationService.getStationsState();
	}

	@PostMapping("/station")
	public ResponseEntity<Station> createStation(@Valid @RequestBody Station createStation) {
		Station station = stationService.createStation(createStation);
		return ResponseEntity.ok(station);
	}

	@PutMapping("/stations/{id}")
	public ResponseEntity<Station> updateStation(@PathVariable(value = "id") Long stationId,
	                                             @Valid @RequestBody Station station) throws StationNotFoundException {
		Station updatedStation = stationService.updateStation(stationId, station);
		return ResponseEntity.ok(updatedStation);
	}

	@DeleteMapping("/stations/{id}")
	public ResponseEntity deleteStation(@PathVariable(value = "id") Long stationId) throws StationNotFoundException {
		stationService.deleteStation(stationId);
		return ResponseEntity.ok().build();
	}

=======
@Slf4j
class StationRestController {


	@GetMapping("/stations")
	public List<StationsResponse> stations() {
		return stationService.getStationsState();
	}

>>>>>>> 94c5cdf... Initial commit
	private final StationService stationService;
}
