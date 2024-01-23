package org.jmez.bookingapi.controller;

import org.jmez.bookingapi.controller.dto.FlightsDTO;
import org.jmez.bookingapi.persistence.entity.Flights;
import org.jmez.bookingapi.service.FlightsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/flight")
public class FlightsController {

    private final FlightsService flightsService;

    public FlightsController(FlightsService flightsService) {
        this.flightsService = flightsService;
    }

    @PostMapping("/save")
    public ResponseEntity<Flights> saveOne(@RequestBody FlightsDTO flightsDTO){

        return ResponseEntity.status(HttpStatus.CREATED).body(flightsService.create(flightsDTO));
    }

    @GetMapping("/findOne/{id}")
    public ResponseEntity<Flights> getOne(@PathVariable String id){
        return ResponseEntity.ok().body(flightsService.getOneForName(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Flights> update(@PathVariable String id, @RequestBody FlightsDTO flightsDTO){
        return ResponseEntity.ok().body(flightsService.update(id, flightsDTO));
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        flightsService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
