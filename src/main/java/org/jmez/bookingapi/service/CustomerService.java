package org.jmez.bookingapi.service;

import org.jmez.bookingapi.controller.dto.CustomerDTO;
import org.jmez.bookingapi.persistence.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CustomerService {

    Customer save(CustomerDTO customerDTO);

    Customer findOne(Long id);

    Page<Customer> paginate(Pageable pageable);

    Customer update(Long id, CustomerDTO customerDTO);
}
