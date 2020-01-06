package com.raczkowska.citynav.station;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import java.util.Set;

@Data
@Builder
@Entity
class Station {
	private Long id;
	private String name;
	private Set<Long> bikeSet;
	private Set<Position> positionSet;
}
