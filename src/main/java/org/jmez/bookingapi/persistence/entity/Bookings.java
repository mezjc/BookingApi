package org.jmez.bookingapi.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reservas")
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Customer customerId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vuelo_id", referencedColumnName = "id")
    private Flights flightsId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "asiento_id", referencedColumnName = "id")
    private Seating seatingId;

}
