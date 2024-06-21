package com.springboot.model.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdenDTO {
    private Long idOrden;
    @NotBlank
    private String descripcion;
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor que 0.")
    private double precio;
    @JsonBackReference
    private LocalDTO local;
}
