package com.springboot.service;

import com.springboot.model.dto.OrdenDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrdenService {
    List<OrdenDTO> findAll();
    OrdenDTO save(OrdenDTO ordenDTO);
}
