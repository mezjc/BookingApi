package org.jmez.bookingapi.service;

import org.jmez.bookingapi.persistence.entity.Airport;

public interface AirportService {

    Airport getOne(Long id);
}
