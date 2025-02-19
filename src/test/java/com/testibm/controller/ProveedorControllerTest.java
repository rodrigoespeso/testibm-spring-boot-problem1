package com.testibm.controller;

import com.testibm.service.ProveedorService;
import com.testibm.vo.ProveedorVO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class ProveedorControllerTest {

    @Mock
    private ProveedorService proveedorService;

    @InjectMocks
    private ProveedorController proveedorController;

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(proveedorController).build();
    }

    @Test
    void testObtenerProveedores_whenClienteExiste() throws Exception {
        // GIVEN
        ProveedorVO[] proveedores = {
            new ProveedorVO(1L, "Coca-cola", LocalDate.of(2024, 1, 1), 5L),
            new ProveedorVO(2L, "Pepsi", LocalDate.of(2024, 2, 1), 5L)
        };
        when(proveedorService.obtenerProveedoresPorCliente(5L)).thenReturn(proveedores);

        // WHEN
        mockMvc.perform(get("/proveedores/5")
                .contentType(MediaType.APPLICATION_JSON))
                
        // THEN
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].nombre").value("Coca-cola"))
                .andExpect(jsonPath("$[1].nombre").value("Pepsi"));

        verify(proveedorService, times(1)).obtenerProveedoresPorCliente(5L);
    }
}
