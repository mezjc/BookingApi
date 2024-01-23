package org.jmez.bookingapi.service.impl;

import org.jmez.bookingapi.persistence.entity.Seating;
import org.jmez.bookingapi.persistence.repository.SeatingRespository;
import org.jmez.bookingapi.service.SeatingService;
import org.springframework.stereotype.Service;

@Service
public class SeatingServiceImpl implements SeatingService {

    private final SeatingRespository seatingRespository;

    public SeatingServiceImpl(SeatingRespository seatingRespository) {
        this.seatingRespository = seatingRespository;
    }

    @Override
    public Seating save(Seating seating) {
        return seatingRespository.save(seating);
    }


}
