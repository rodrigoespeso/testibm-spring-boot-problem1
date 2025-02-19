package com.testibm.repository;

import com.testibm.entity.ProveedorEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Sql(scripts = "/reset.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class ProveedorRepositoryTest {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Test
    void testFindByIdCliente() {
        // GIVEN
        ProveedorEntity proveedor1 = new ProveedorEntity(null, "Coca-cola", LocalDate.of(2024, 1, 1), 5L);
        ProveedorEntity proveedor2 = new ProveedorEntity(null, "Pepsi", LocalDate.of(2024, 2, 1), 5L);
        proveedorRepository.save(proveedor1);
        proveedorRepository.save(proveedor2);

        // WHEN
        List<ProveedorEntity> proveedores = proveedorRepository.findByIdCliente(5L);

        // THEN
        assertEquals(2, proveedores.size());
        assertTrue(proveedores.stream().anyMatch(p -> p.getNombre().equals("Coca-cola")));
        assertTrue(proveedores.stream().anyMatch(p -> p.getNombre().equals("Pepsi")));
    }
}
