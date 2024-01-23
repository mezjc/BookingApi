package org.jmez.bookingapi.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FligthResponseDTO {

    private String numeroVuelo;
    private LocalDateTime horaLlegada;
    private LocalDateTime salida;
    private String aerolinea;
    private OrigenDTO origen;
    private OrigenDTO destino;

}
