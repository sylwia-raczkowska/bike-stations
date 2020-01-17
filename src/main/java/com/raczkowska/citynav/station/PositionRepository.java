package com.raczkowska.citynav.station;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface PositionRepository extends CrudRepository<Position, Long> {

	Optional<Position> findByIdAndStationStationId(Long id, Long stationId);

}
