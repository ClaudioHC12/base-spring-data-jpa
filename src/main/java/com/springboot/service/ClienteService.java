package com.springboot.service;

import com.springboot.model.dto.ClienteDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClienteService {

    List<ClienteDTO> findAll();
    ClienteDTO save(ClienteDTO cliente);
    ClienteDTO findById(Long id);
    ClienteDTO deleteById(Long id);
    ClienteDTO updateById(Long id, ClienteDTO cliente);
}
