package com.springboot.mapper;

import com.springboot.model.dto.DireccionDTO;
import com.springboot.model.entity.Direccion;
import org.modelmapper.ModelMapper;

public class DireccionMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static DireccionDTO mapToDto(Direccion direccion){
        return modelMapper.map(direccion, DireccionDTO.class);
    }

    public static Direccion mapToEntity(DireccionDTO direccionDTO){
        return modelMapper.map(direccionDTO, Direccion.class);
    }
}
