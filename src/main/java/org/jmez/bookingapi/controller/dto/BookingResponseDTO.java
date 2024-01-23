package org.jmez.bookingapi.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponseDTO {

    private CustomerDTO cliente;

    private FligthResponseDTO detallesVuelo;

    private SeatingDTO detalleAsientos;



}
