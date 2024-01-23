package org.jmez.bookingapi.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrigenDTO {
    private String aeropuesto;
    private String codIata;
    private String pais;

}
