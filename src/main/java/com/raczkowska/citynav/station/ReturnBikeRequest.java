package com.raczkowska.citynav.station;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
class ReturnBikeRequest {

	private Long stationId;
	private Long positionId;
}
