package com.testibm.service;

import com.testibm.entity.ProveedorEntity;
import com.testibm.mapper.ProveedorMapper;
import com.testibm.repository.ProveedorRepository;
import com.testibm.vo.ProveedorVO;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;

    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    public ProveedorVO[] obtenerProveedoresPorCliente(Long idCliente) {
        List<ProveedorEntity> proveedores = proveedorRepository.findByIdCliente(idCliente);
        return ProveedorMapper.toVOArray(proveedores);
    }
}