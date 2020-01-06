package com.raczkowska.citynav.station;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
class Position {
	private boolean available;
}
