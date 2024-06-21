package com.springboot.service.impl;

import com.springboot.mapper.LocalMapper;
import com.springboot.model.dto.LocalDTO;
import com.springboot.model.entity.Local;
import com.springboot.repository.LocalRepository;
import com.springboot.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocalServiceImpl implements LocalService {

    @Autowired
    private LocalRepository localRepository;

    @Override
    public List<LocalDTO> findAll() {
        List<LocalDTO> locales = new ArrayList<>();
        localRepository.findAll().forEach(local -> {
            locales.add(LocalMapper.mapToDto(local));
        });
        return locales;
    }

    @Override
    public LocalDTO save(LocalDTO localDTO) {
        Local local = localRepository.save(LocalMapper.mapToEntity(localDTO));
        return LocalMapper.mapToDto(local);
    }
}
