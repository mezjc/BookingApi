package org.jmez.bookingapi.persistence.repository;

import org.jmez.bookingapi.persistence.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {


}
