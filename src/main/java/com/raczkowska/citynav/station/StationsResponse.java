package com.raczkowska.citynav.station;

import lombok.Data;

@Data
class StationsResponse {
	private String name;
	private Integer availablePositionAmount;
	private Integer occupiedPositionAmount;
	private Integer availableBikesAmount;

}
