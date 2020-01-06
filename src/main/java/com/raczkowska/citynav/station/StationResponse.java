package com.raczkowska.citynav.station;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class StationResponse {
	private String name;
	private Integer availablePositionAmount;
	private Integer occupiedPositionAmount;
	private Integer availableBikesAmount;

}
