package com.springboot.model.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GerenteDTO {
    private Long idGerente;
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @JsonBackReference
    private LocalDTO local;
}
