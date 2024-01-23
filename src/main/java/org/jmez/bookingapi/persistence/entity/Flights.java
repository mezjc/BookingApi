package org.jmez.bookingapi.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vuelos")
public class Flights {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_vuelo", length = 30)
    private String flightNumber;

    @Column(name = "fecha_llegada", columnDefinition = "DATETIME")
    private LocalDateTime arrival;

    @Column(name = "fecha_salida", columnDefinition = "DATETIME")
    private LocalDateTime departure;


    @ManyToOne
    @JoinColumn(name = "id_aerolinea", referencedColumnName = "id")
    private Airlines airlines;


    @ManyToOne
    @JoinColumn(name = "aeropuerto_origen", referencedColumnName = "id")
    private Airport origin;


    @ManyToOne
    @JoinColumn(name = "aeropuerto_destino", referencedColumnName = "id" )
    private Airport destination;

}
