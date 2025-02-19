package com.testibm.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "PROVEEDORES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProveedorEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProveedor;

    private String nombre;
    private LocalDate fechaAlta;
    private Long idCliente;
           
}
