package com.springboot.model.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocalDTO {
    private Long idLocal;
    @NotBlank
    private String nombre;
    @NotBlank
    private String piso;

    private GerenteDTO gerente;
    @JsonBackReference
    private List<OrdenDTO> ordenes;
    private Set<ClienteDTO> clientes;
}
