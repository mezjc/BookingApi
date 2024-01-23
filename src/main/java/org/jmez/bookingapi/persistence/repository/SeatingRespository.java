package org.jmez.bookingapi.persistence.repository;

import org.jmez.bookingapi.persistence.entity.Seating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatingRespository extends JpaRepository<Seating, Long> {



}
