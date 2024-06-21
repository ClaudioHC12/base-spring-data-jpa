package com.springboot.repository;

import com.springboot.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByNombre(String nombre);

    List<Cliente> findByNombreContaining(String nombre);

    @Query("SELECT c FROM Cliente c WHERE c.email = ?1")
    Cliente getClienteByEmail(String email);

    @Query("SELECT c.nombre FROM Cliente c WHERE c.apellido = ?1")
    String getNombreClienteByApellido(String apellido);

    @Query(value = "SELECT * FROM cliente c WHERE c.numero = :numero", nativeQuery = true)
    Cliente getClienteByNumero(@Param("numero") String numero);
}
