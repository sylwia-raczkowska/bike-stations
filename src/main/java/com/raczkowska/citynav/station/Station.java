package com.raczkowska.citynav.station;

import lombok.Data;

import javax.persistence.Entity;
import java.util.Set;

@Data
@Entity
class Station {
	private Long id;
	private String name;
	private Set<Long> bikeSet;
}
