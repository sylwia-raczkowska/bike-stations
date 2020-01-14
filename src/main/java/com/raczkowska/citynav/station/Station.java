package com.raczkowska.citynav.station;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
class Station {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long stationId;
	private String name;
	@OneToMany(mappedBy = "station", cascade = CascadeType.ALL)
	@BatchSize(size = 10)
	private Set<Bike> bikeSet;
	@OneToMany(mappedBy = "station", cascade = CascadeType.ALL)
	@BatchSize(size = 10)
	private Set<Position> positionSet;
}
