package com.raczkowska.citynav.station;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
<<<<<<< HEAD
interface StationRepository extends JpaRepository<Station, Long> {
=======
interface StationRepository extends JpaRepository<Long, Station> {
>>>>>>> 94c5cdf... Initial commit
}
