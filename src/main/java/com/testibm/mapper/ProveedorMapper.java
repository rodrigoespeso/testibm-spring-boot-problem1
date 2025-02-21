package com.testibm.mapper;

import com.testibm.entity.ProveedorEntity;
import com.testibm.vo.ProveedorVO;
import java.util.List;
import java.util.stream.Collectors;

public class ProveedorMapper {
    
    public static ProveedorVO toVO(ProveedorEntity entity) {
        return new ProveedorVO(
            entity.getIdProveedor(),
            entity.getNombre(),
            entity.getFechaAlta(),
            entity.getIdCliente()
        );
    }

    public static List<ProveedorVO> toVOList(List<ProveedorEntity> entities) {
        return entities.stream().map(ProveedorMapper::toVO).collect(Collectors.toList());
    }
    
    public static ProveedorVO[] toVOArray(List<ProveedorEntity> entities) {
        List<ProveedorVO> voList = toVOList(entities);
        return voList.toArray(new ProveedorVO[0]); // con parametro evitamos cast
    }
}
