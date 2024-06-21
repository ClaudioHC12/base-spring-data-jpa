package com.springboot.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class Direccion {
    @Column(name = "ciudad", nullable = true)
    private String ciudad;
    @Column(name = "colonia", nullable = true)
    private String colonia;
    @Column(name = "calle", nullable = true)
    private String calle;
    @Column(name = "numero", nullable = true)
    private String numero;
}
