package com.springboot.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "local")
@Entity
@Table(name = "gerente")
public class Gerente implements Serializable {
    @Id
    @Column(name = "id_gerente", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGerente;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellido", nullable = false)
    private String apellido;

    @OneToOne(mappedBy = "gerente", orphanRemoval = true)
    @JsonBackReference
    private Local local;
}
