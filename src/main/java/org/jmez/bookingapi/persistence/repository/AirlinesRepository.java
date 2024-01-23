package org.jmez.bookingapi.persistence.repository;

import org.jmez.bookingapi.persistence.entity.Airlines;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlinesRepository extends JpaRepository<Airlines, Long> {

}


