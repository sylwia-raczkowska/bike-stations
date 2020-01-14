package com.raczkowska.citynav.station;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Builder
@Entity
@Data
@EqualsAndHashCode(exclude={"station", "bike"})
@ToString(exclude={"station", "bike"})
@NoArgsConstructor
@AllArgsConstructor
class Position {
	@Id
	private Long id;
	private boolean available = true;
	@OneToOne(mappedBy = "position")
	@JoinColumn(name = "bikeId", referencedColumnName = "id")
	private Bike bike;
	@ManyToOne
	@JoinColumn(name = "stationId")
	private Station station;
}
