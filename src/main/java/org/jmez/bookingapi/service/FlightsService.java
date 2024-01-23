package org.jmez.bookingapi.service;

import org.jmez.bookingapi.controller.dto.FlightsDTO;
import org.jmez.bookingapi.persistence.entity.Flights;

public interface FlightsService {
    Flights create(FlightsDTO flightsDTO);

    Flights getOneForName(String name);

    Flights update(String id, FlightsDTO flightsDTO);

    void delete(String id);
}
