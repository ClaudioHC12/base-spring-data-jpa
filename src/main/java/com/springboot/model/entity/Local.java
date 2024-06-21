package com.springboot.model.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"ordenes", "gerente"})
@Entity
@Table(name = "local")
public class Local implements Serializable {
    @Id
    @Column(name = "id_local", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLocal;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "piso", nullable = false)
    private String piso;

    @OneToOne
    @JoinColumn(name = "idGerente", referencedColumnName = "id_gerente")
    @JsonManagedReference
    private Gerente gerente;

    @OneToMany(mappedBy = "local", orphanRemoval = true)
    @JsonManagedReference
    private List<Orden> ordenes;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "local_cliente",
            joinColumns = @JoinColumn(name = "idLocal", referencedColumnName = "id_local"),
            inverseJoinColumns = @JoinColumn(name = "idCliente", referencedColumnName = "id_cliente")
    )
    @JsonManagedReference
    private Set<Cliente> clientes;
}
