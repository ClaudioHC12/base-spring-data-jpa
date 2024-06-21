package com.springboot.mapper;

import com.springboot.model.dto.OrdenDTO;
import com.springboot.model.entity.Orden;
import org.modelmapper.ModelMapper;

public class OrdenMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static OrdenDTO mapToDto(Orden orden){
        return modelMapper.map(orden, OrdenDTO.class);
    }

    public static Orden mapToEntity(OrdenDTO ordenDTO){
        return modelMapper.map(ordenDTO, Orden.class);
    }
}
