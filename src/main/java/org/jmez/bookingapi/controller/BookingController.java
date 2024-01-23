package org.jmez.bookingapi.controller;

import org.jmez.bookingapi.controller.dto.BookingDTO;
import org.jmez.bookingapi.controller.dto.BookingResponseDTO;
import org.jmez.bookingapi.persistence.entity.Bookings;
import org.jmez.bookingapi.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/save")
    public ResponseEntity<Bookings> saveBooking(@RequestBody BookingDTO bookingDTO){
        Bookings bookings = bookingService.create(bookingDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(bookings);

    }
}
