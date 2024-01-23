package org.jmez.bookingapi.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private String nombre;
    private String apellido;
    private String documento;
    private String correo;
}
