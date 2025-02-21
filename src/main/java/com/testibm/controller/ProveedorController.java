	package com.testibm.controller;

import com.testibm.service.ProveedorService;
import com.testibm.vo.ProveedorVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @Operation(summary = "Obtener proveedores por ID de cliente", description = "Devuelve un array de proveedores asociados a un cliente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de proveedores encontrada"),
    })
    @GetMapping("/{idCliente}")
    public ResponseEntity<ProveedorVO[]> obtenerProveedores(@PathVariable Long idCliente) {
        ProveedorVO [] proveedores = proveedorService.obtenerProveedoresPorCliente(idCliente);

        return ResponseEntity.ok(proveedores);
    }
}
