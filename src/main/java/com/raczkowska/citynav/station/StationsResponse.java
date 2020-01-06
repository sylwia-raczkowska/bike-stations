package com.raczkowska.citynav.station;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
class StationsResponse {
	private String name;
	private Integer availablePositionAmount;
	private Integer occupiedPositionAmount;
	private Integer availableBikesAmount;

}
