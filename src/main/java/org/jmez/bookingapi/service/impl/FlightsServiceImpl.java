package org.jmez.bookingapi.service.impl;

import org.jmez.bookingapi.controller.dto.FlightsDTO;
import org.jmez.bookingapi.persistence.entity.Airlines;
import org.jmez.bookingapi.persistence.entity.Airport;
import org.jmez.bookingapi.persistence.entity.Flights;
import org.jmez.bookingapi.persistence.repository.FlightsRepository;
import org.jmez.bookingapi.service.AirlinesService;
import org.jmez.bookingapi.service.AirportService;
import org.jmez.bookingapi.service.FlightsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class FlightsServiceImpl implements FlightsService {

    private final FlightsRepository flightsRepository;
    private final AirlinesService airlinesService;

    private final AirportService airportService;

    public FlightsServiceImpl(FlightsRepository flightsRepository, AirlinesService airlinesService, AirportService airportService) {
        this.flightsRepository = flightsRepository;
        this.airlinesService = airlinesService;
        this.airportService = airportService;
    }

    @Override
    public Flights create(FlightsDTO flightsDTO) {
        System.out.println(flightsDTO + " desde el controller");
        Airlines airlines = airlinesService.getOne(flightsDTO.getIdAerolinea());
        Airport airportOrigen = airportService.getOne(flightsDTO.getAeropuertoSalidaId());
        Airport airportDestination = airportService.getOne(flightsDTO.getAeropuertoOrigenId());

        Flights flights = new Flights();
        flights.setFlightNumber(flightsDTO.getNumeroVuelo());
        flights.setArrival(flightsDTO.getFechaLlegada());
        flights.setDeparture(flightsDTO.getFechaSalida());
        flights.setAirlines(airlines);
        flights.setOrigin(airportOrigen);
        flights.setDestination(airportDestination);

//        Flights flights = new ModelMapper().map(flightsDTO, Flights.class );
        System.out.println(flights);

        return flightsRepository.save(flights);
    }

    @Override
    public Flights getOneForName(String name) {
        return flightsRepository.findByFlightNumber(name).orElseThrow();
    }

    @Override
    public Flights update(String id, FlightsDTO flightsDTO) {
        Flights flights = getOneForName(id);

        Airport airportDestination = airportService.getOne(flightsDTO.getAeropuertoOrigenId());
        flights.setDestination(airportDestination);

        Airport airportOrigen = airportService.getOne(flightsDTO.getAeropuertoSalidaId());
        flights.setOrigin(airportOrigen);

        Airlines airlines = airlinesService.getOne(flightsDTO.getIdAerolinea());
        flights.setAirlines(airlines);

        return flightsRepository.save(flights);
    }

    @Override
    public void delete(String id) {
         flightsRepository.deleteByFlightNumber(id);
    }

}
