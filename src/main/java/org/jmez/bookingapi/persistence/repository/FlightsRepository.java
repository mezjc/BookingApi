package org.jmez.bookingapi.persistence.repository;

import org.jmez.bookingapi.persistence.entity.Flights;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlightsRepository extends JpaRepository<Flights, Long> {

    Optional<Flights> findByFlightNumber (String name);

    void deleteByFlightNumber (String name);
}
