package com.springboot.controller;

import com.springboot.model.dto.LocalDTO;
import com.springboot.service.LocalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.base.path}/locales")
public class LocalController {

    @Autowired
    private LocalService localService;

    @GetMapping("")
    public ResponseEntity<List<LocalDTO>> obtenerLocales(){
        return new ResponseEntity<>(localService.findAll(), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<LocalDTO> guardarLocal(@RequestBody @Valid LocalDTO localDTO){
        return new ResponseEntity<>(localService.save(localDTO), HttpStatus.CREATED);
    }
}
