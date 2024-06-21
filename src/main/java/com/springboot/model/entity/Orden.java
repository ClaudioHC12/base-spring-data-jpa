package com.springboot.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString()
@Entity
@Table(name = "orden")
public class Orden {
    @Id
    @Column(name = "id_orden", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrden;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @Column(name = "precio", nullable = false)
    private double precio;

    @ManyToOne()
    @JoinColumn(name = "idLocal", referencedColumnName = "id_local")
    @JsonManagedReference
    private Local local;
}
