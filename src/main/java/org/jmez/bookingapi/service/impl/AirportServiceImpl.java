package org.jmez.bookingapi.service.impl;

import org.jmez.bookingapi.persistence.entity.Airport;
import org.jmez.bookingapi.persistence.repository.AirportRepository;
import org.jmez.bookingapi.service.AirportService;
import org.springframework.stereotype.Service;

@Service
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;

    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public Airport getOne(Long id) {
        return airportRepository.findById(id).orElseThrow();
    }
}
