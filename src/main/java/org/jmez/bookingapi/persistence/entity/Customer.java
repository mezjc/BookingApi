package org.jmez.bookingapi.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 30)
    private String firstname;

    @Column(name = "apellidos", nullable = false, length = 30)
    private String lastname;

    @Column(name = "identificacion", nullable = false, length = 30)
    private String identificacion;

    @Column(name = "correo", nullable = false, length = 30)
    private String email;

}
