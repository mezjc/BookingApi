package org.jmez.bookingapi.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightsDTO {

    private String numeroVuelo;

    private LocalDateTime fechaLlegada;
    private LocalDateTime fechaSalida;

    private Long idAerolinea;
    private Long aeropuertoOrigenId;
    private Long aeropuertoSalidaId;
}
