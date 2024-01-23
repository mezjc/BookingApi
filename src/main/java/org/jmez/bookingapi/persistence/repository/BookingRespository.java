package org.jmez.bookingapi.persistence.repository;


import org.jmez.bookingapi.persistence.entity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRespository extends JpaRepository<Bookings, Long> {

}
