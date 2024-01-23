package org.jmez.bookingapi.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "asientos")
public class Seating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_asiento")
    private Long seatNumber;

    @Column(name = "clase")
    @Enumerated(EnumType.STRING)
    private Clase clase;

    @Column(name = "ubicacion")
    @Enumerated(EnumType.STRING)
    private Location location;

//    @Column(name = "disponibilidad")
//    private Boolean availability;


    public static enum Clase{
        ECONOMICO,
        EJECUTIVO,
        PRIMERA_CLASE
    }

    public static enum Location{
        VENTANA,
        PASILLO,
        MEDIO
    }
}

