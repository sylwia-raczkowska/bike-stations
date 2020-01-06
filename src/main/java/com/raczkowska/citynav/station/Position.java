package com.raczkowska.citynav.station;

<<<<<<< HEAD
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Builder
@Entity
@Data
@EqualsAndHashCode(exclude="station")
@ToString(exclude="station")
class Position {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private boolean available;
	@ManyToOne
	@JoinColumn(name = "stationId")
	private Station station;
=======
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
class Position {
	private boolean available;
>>>>>>> 94c5cdf... Initial commit
}
