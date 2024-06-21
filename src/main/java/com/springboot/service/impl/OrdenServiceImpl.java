package com.springboot.service.impl;

import com.springboot.mapper.OrdenMapper;
import com.springboot.model.dto.OrdenDTO;
import com.springboot.model.entity.Orden;
import com.springboot.repository.OrdenRepository;
import com.springboot.service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdenServiceImpl implements OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    @Override
    public List<OrdenDTO> findAll() {
        List<OrdenDTO> ordenes = new ArrayList<>();
        ordenRepository.findAll().forEach(orden ->{
            ordenes.add(OrdenMapper.mapToDto(orden));
        });
        return ordenes;
    }

    @Override
    public OrdenDTO save(OrdenDTO ordenDTO) {
        Orden orden = ordenRepository.save(OrdenMapper.mapToEntity(ordenDTO));
        return OrdenMapper.mapToDto(orden);
    }
}
