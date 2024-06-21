package com.springboot.mapper;

import com.springboot.model.dto.ClienteDTO;
import com.springboot.model.entity.Cliente;
import org.modelmapper.ModelMapper;

public class ClienteMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static ClienteDTO mapToDto(Cliente cliente){
        return modelMapper.map(cliente, ClienteDTO.class);
    }

    public static Cliente mapToEntity(ClienteDTO clienteDTO){
        return modelMapper.map(clienteDTO, Cliente.class);
    }
}
