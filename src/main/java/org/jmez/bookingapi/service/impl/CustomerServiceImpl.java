package org.jmez.bookingapi.service.impl;

import org.jmez.bookingapi.controller.dto.CustomerDTO;
import org.jmez.bookingapi.exceptions.ResourceNotFoundException;
import org.jmez.bookingapi.persistence.entity.Customer;
import org.jmez.bookingapi.persistence.repository.CustomerRespository;
import org.jmez.bookingapi.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRespository customerRespository;

    public CustomerServiceImpl(CustomerRespository customerRespository) {
        this.customerRespository = customerRespository;
    }

    @Override
    public Customer save(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setFirstname(customerDTO.getNombre());
        customer.setLastname(customerDTO.getApellido());
        customer.setIdentificacion(customerDTO.getDocumento());
        customer.setEmail(customerDTO.getCorreo());
        return customerRespository.save(customer);
    }

    @Override
    public Customer findOne(Long id) {
        return customerRespository.findById(id).orElseThrow(()-> new ResourceNotFoundException("asd"));
    }

    @Override
    public Page<Customer> paginate(Pageable pageable) {
        return customerRespository.findAll(pageable);
    }

    @Override
    public Customer update(Long id, CustomerDTO customerDTO) {
        Customer customer = findOne(id);
        customer.setFirstname(customerDTO.getNombre());
        customer.setLastname(customerDTO.getApellido());
        customer.setIdentificacion(customerDTO.getDocumento());
        customer.setEmail(customerDTO.getCorreo());


        return customerRespository.save(customer);
    }
}
