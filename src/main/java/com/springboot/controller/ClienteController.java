package com.springboot.controller;

import com.springboot.model.dto.ClienteDTO;
import com.springboot.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.base.path}/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("")
    public ResponseEntity<List<ClienteDTO>> obtenerClientes(){
        return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<ClienteDTO> registrarCliente(@RequestBody @Valid ClienteDTO cliente){
        return new ResponseEntity<>(clienteService.save(cliente), HttpStatus.CREATED);
    }
    @GetMapping("/{id:\\d+}")
    public ResponseEntity<ClienteDTO> consultarClientePorId(@PathVariable("id") Long id){
        return new ResponseEntity<>(clienteService.findById(id), HttpStatus.OK);
    }
    @DeleteMapping("/{id:\\d+}")
    public ResponseEntity<ClienteDTO> borrarCliente(@PathVariable("id") Long id) {
        return new ResponseEntity<>(clienteService.deleteById(id), HttpStatus.OK);
    }
    @PutMapping("/{id:\\d+}")
    public ResponseEntity<ClienteDTO> actualizarCliente(
            @PathVariable Long id, @RequestBody @Valid ClienteDTO clienteDTO){
        ClienteDTO updatedCliente = clienteService.updateById(id, clienteDTO);
        return new ResponseEntity<>(updatedCliente, HttpStatus.OK);
    }
}
