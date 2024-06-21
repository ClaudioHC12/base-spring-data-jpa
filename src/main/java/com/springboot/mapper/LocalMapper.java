package com.springboot.mapper;

import com.springboot.model.dto.LocalDTO;
import com.springboot.model.entity.Local;
import org.modelmapper.ModelMapper;

public class LocalMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static LocalDTO mapToDto(Local local){
        return modelMapper.map(local, LocalDTO.class);
    }

    public static Local mapToEntity(LocalDTO localDTO){
        return modelMapper.map(localDTO, Local.class);
    }
}
