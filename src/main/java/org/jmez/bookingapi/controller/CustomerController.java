package org.jmez.bookingapi.controller;

import org.jmez.bookingapi.controller.dto.CustomerDTO;
import org.jmez.bookingapi.persistence.entity.Customer;
import org.jmez.bookingapi.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/findOne/{id}")
    public ResponseEntity<Customer> findOne(@PathVariable Long id){
        Customer customer = customerService.findOne(id);
        return ResponseEntity.ok().body(customer);
    }

    @GetMapping("/findAll")
    public Page<Customer> paginate(@PageableDefault(sort = "firstname", size = 2)Pageable pageable){
        return customerService.paginate(pageable);
    }

    @PostMapping("/create")
    public ResponseEntity<Customer> save(@RequestBody CustomerDTO customerDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customerDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody CustomerDTO customerDTO){
        return ResponseEntity.ok().body(customerService.update(id, customerDTO));
    }
}
