package com.testibm.repository;

import com.testibm.entity.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Long> {
    
    List<ProveedorEntity> findByIdCliente(Long idCliente);
}
