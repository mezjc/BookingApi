package org.jmez.bookingapi.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jmez.bookingapi.persistence.entity.Seating;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatingDTO {

    private Long seatNumber;
    private Seating.Clase clase;
    private Seating.Location location;
}
