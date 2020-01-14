package com.raczkowska.citynav.station;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Data
@Builder
@EqualsAndHashCode(exclude={"station", "position"})
@ToString(exclude={"station", "position"})
@NoArgsConstructor
@AllArgsConstructor
class Bike {
	@Id
	@GeneratedValue
	private Long bikeId;
	@OneToOne(cascade = CascadeType.ALL)
	private Position position;
	@ManyToOne
	@JoinColumn(name = "stationId")
	private Station station;
}
