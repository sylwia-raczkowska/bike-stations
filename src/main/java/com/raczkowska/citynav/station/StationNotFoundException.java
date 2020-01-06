package com.raczkowska.citynav.station;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
class StationNotFoundException extends Exception {
	private Long stationId;
}
