package com.raczkowska.citynav.station;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface StationRepository extends JpaRepository<Station, Long> {
}
