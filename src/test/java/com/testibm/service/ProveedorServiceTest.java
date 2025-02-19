package com.testibm.service;

import com.testibm.entity.ProveedorEntity;
import com.testibm.repository.ProveedorRepository;
import com.testibm.vo.ProveedorVO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProveedorServiceTest {

    @Mock
    private ProveedorRepository proveedorRepository;

    @InjectMocks
    private ProveedorService proveedorService;

    @Test
    void obtenerProveedoresPorCliente() {
        List<ProveedorEntity> proveedores = Arrays.asList(
                new ProveedorEntity(1L, "Coca-cola", null, 5L),
                new ProveedorEntity(2L, "Pepsi", null, 5L)
        );

        when(proveedorRepository.findByIdCliente(5L)).thenReturn(proveedores);

        ProveedorVO[] resultado = proveedorService.obtenerProveedoresPorCliente(5L);

        assertEquals(2, resultado.length);
        assertEquals("Coca-cola", resultado[0].getNombre());
        assertEquals("Pepsi", resultado[1].getNombre());
    }
}
