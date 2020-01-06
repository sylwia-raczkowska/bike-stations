package com.raczkowska.citynav.station;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.BatchSize;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Builder
@Entity
class Station {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long stationId;
	private String name;
	@OneToMany(mappedBy = "station")
	@BatchSize(size = 10)
	private Set<Bike> bikeSet;
	@OneToMany(mappedBy = "station")
	@BatchSize(size = 10)
	private Set<Position> positionSet;
}
