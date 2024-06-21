package com.springboot.service;

import com.springboot.model.dto.LocalDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocalService {
    List<LocalDTO> findAll();
    LocalDTO save(LocalDTO localDTO);
}
