package org.jmez.bookingapi.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "aeropuerto")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String name;

    @Column(name = "IATA", nullable = false, length = 30)
    private String codIata;

    @Column(name = "ubicacion", nullable = false, length = 30)
    private String location;


//    @OneToMany(mappedBy = "origin")
//    private List<Flights> flights;

//    @OneToMany(mappedBy = "origin", cascade = CascadeType.ALL)
//    private List<Flights> flights;



}
