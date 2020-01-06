package com.raczkowska.citynav.station;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@Builder
@EqualsAndHashCode(exclude="station")
@ToString(exclude="station")
class Bike {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bikeId;
	@ManyToOne
	@JoinColumn(name = "stationId")
	private Station station;
}
