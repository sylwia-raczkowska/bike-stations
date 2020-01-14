package com.raczkowska.citynav.station;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface BikeRepository extends CrudRepository<Bike, Long> {


}

