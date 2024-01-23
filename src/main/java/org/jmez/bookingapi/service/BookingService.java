package org.jmez.bookingapi.service;

import org.jmez.bookingapi.controller.dto.BookingDTO;
import org.jmez.bookingapi.controller.dto.BookingResponseDTO;
import org.jmez.bookingapi.persistence.entity.Bookings;

public interface BookingService {

    Bookings create (BookingDTO bookingDTO);
}
