package org.jmez.bookingapi.service.impl;

import org.jmez.bookingapi.controller.dto.*;
import org.jmez.bookingapi.persistence.entity.*;
import org.jmez.bookingapi.persistence.repository.AirlinesRepository;
import org.jmez.bookingapi.persistence.repository.BookingRespository;
import org.jmez.bookingapi.persistence.repository.CustomerRespository;
import org.jmez.bookingapi.persistence.repository.SeatingRespository;
import org.jmez.bookingapi.service.AirportService;
import org.jmez.bookingapi.service.BookingService;
import org.jmez.bookingapi.service.FlightsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRespository bookingRespository;

    private final SeatingRespository seatingRespository;

    private final FlightsService flightsService;
    private final CustomerRespository customerRespository;

    public BookingServiceImpl(BookingRespository bookingRespository, AirlinesRepository airlinesRepository, AirportService airportService, SeatingRespository seatingRespository, FlightsService flightsService, CustomerRespository customerRespository) {
        this.bookingRespository = bookingRespository;
        this.seatingRespository = seatingRespository;
        this.flightsService = flightsService;
        this.customerRespository = customerRespository;
    }


    @Override
    public Bookings create(BookingDTO bookingDTO) {
        Bookings bookings = new Bookings();

        //extraemos cliente
        Customer customer = customerRespository.findById(bookingDTO.getIdCliente()).get();
        CustomerDTO customerDTO = new ModelMapper().map(customer, CustomerDTO.class);

        //extraemos el Vuelo
        Flights flights = flightsService.getOneForName(bookingDTO.getNumeroVuelo());
        FligthResponseDTO fligthResponseDTO =new ModelMapper().map(flights, FligthResponseDTO.class);

        //extraemos asientos
        SeatingDTO seatingDTO = bookingDTO.getAsiento();
        Seating seating = new ModelMapper().map(seatingDTO, Seating.class);
        //seatingRespository.save(seating);

        //SeatingDTO dto = new ModelMapper().map(seating,SeatingDTO.class);

        bookings.setCustomerId(customer);
        bookings.setFlightsId(flights);
        bookings.setSeatingId(seating);
        //System.out.println(seating + " desde el controler");


        return bookingRespository.save(bookings);
    }
}
