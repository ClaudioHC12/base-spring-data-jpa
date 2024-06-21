package com.springboot.controller;

import com.springboot.model.dto.OrdenDTO;
import com.springboot.service.OrdenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.base.path}/ordenes")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;

    @GetMapping("")
    public ResponseEntity<List<OrdenDTO>> obtenerOrdenes(){
        return new ResponseEntity<>(ordenService.findAll(), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<OrdenDTO> guardarOrden(@RequestBody @Valid OrdenDTO ordenDTO){
        return new ResponseEntity<>(ordenService.save(ordenDTO), HttpStatus.CREATED);
    }
}
