package com.testibm.vo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProveedorVO {
    
    private Long idProveedor;
    private String nombre;
    private LocalDate fechaAlta;
    private Long idCliente;

}
