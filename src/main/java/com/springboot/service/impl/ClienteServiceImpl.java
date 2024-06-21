package com.springboot.service.impl;

import com.springboot.exception.ModelNotFoundException;
import com.springboot.exception.ResourceReferenceException;
import com.springboot.mapper.ClienteMapper;
import com.springboot.mapper.DireccionMapper;
import com.springboot.model.dto.ClienteDTO;
import com.springboot.model.entity.Cliente;
import com.springboot.repository.ClienteRepository;
import com.springboot.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteDTO> findAll() {
        List<ClienteDTO> clientes = new ArrayList<>();
        clienteRepository.findAll().forEach(cliente -> {
            clientes.add(ClienteMapper.mapToDto(cliente));
        });
        return clientes;
    }

    @Override
    public ClienteDTO save(ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.save(ClienteMapper.mapToEntity(clienteDTO));
        return ClienteMapper.mapToDto(cliente);
    }

    @Override
    public ClienteDTO findById(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente == null){
            throw new ModelNotFoundException("Cliente NO encontrado");
        }
        return ClienteMapper.mapToDto(cliente);
    }

    @Override
    public ClienteDTO deleteById(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente == null){
            throw new ModelNotFoundException("Cliente NO encontrado");
        }
        try {
            clienteRepository.deleteById(id);
        }catch (Exception ex){
            throw new ResourceReferenceException(ex.getLocalizedMessage());
        }
        return ClienteMapper.mapToDto(cliente);
    }

    @Override
    public ClienteDTO updateById(Long id, ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() ->
                new ModelNotFoundException("Cliente NO encontrado"));
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setApellido(clienteDTO.getApellido());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setDireccion(DireccionMapper.mapToEntity(clienteDTO.getDireccion()));
        return ClienteMapper.mapToDto(clienteRepository.save(cliente));
    }
}
