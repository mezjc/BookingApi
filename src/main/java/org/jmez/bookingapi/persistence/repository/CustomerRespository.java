package org.jmez.bookingapi.persistence.repository;

import org.jmez.bookingapi.persistence.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRespository extends JpaRepository<Customer, Long> {


}
