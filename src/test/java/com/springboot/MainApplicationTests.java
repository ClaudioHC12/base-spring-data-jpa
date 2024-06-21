package com.springboot;

import com.springboot.model.entity.*;
import com.springboot.repository.ClienteRepository;
import com.springboot.repository.GerenteRepository;
import com.springboot.repository.LocalRepository;
import com.springboot.repository.OrdenRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MainApplicationTests {

	@Autowired
	ClienteRepository repository;

	@Autowired
	LocalRepository localRepository;

	@Autowired
	GerenteRepository gerenteRepository;

	@Autowired
	OrdenRepository ordenRepository;

	@Test
	void contextLoads() {
		Cliente cliente = new Cliente();
		Direccion direccion = new Direccion("ramos", "Vsol", "nico", "399");
		cliente.setNombre("clau");
		cliente.setApellido("hc");
		cliente.setEmail("email");
		cliente.setDireccion(direccion);
		repository.save(cliente);
	}
	@Test
	void contextGET() {
		Cliente cliente = repository.findByNombre("clau").get();
		System.out.println(cliente);
	}
	@Test
	void contextGetNombreContaining() {
		List<Cliente> clientes = repository.findByNombreContaining("cl");
		System.out.println(clientes);
	}
	@Test
	void contextGetEmail() {
		Cliente cliente = repository.getClienteByEmail("email");
		System.out.println(cliente);
	}
	@Test
	void contextGetNombreCliente() {
		String nombreCliente = repository.getNombreClienteByApellido("hc");
		System.out.println(nombreCliente);
	}
	@Test
	void contextGetNumero() {
		Cliente cliente = repository.getClienteByNumero("399");
		System.out.println(cliente);
	}
	@Test
	void contextSaveLocal() {
		Gerente gerente = new Gerente();
		gerente.setIdGerente(1L);
		gerente.setNombre("claudio");
		gerente.setApellido("hdzC");

		Local local = new Local();
		local.setNombre("apple");
		local.setPiso("piso 1");
		local.setGerente(gerente);
		localRepository.save(local);
	}
	@Test
	void contextSaveGerente() {
		Gerente gerente = new Gerente();
		gerente.setNombre("claudio");
		gerente.setApellido("hdzC");
		gerenteRepository.save(gerente);
	}
	@Test
	void contextgetAllLocal() {
		List<Local> locales = localRepository.findAll();
		System.out.println(locales);
	}
	@Test
	void contextgetAllGerente() {
		List<Gerente> gerentes = gerenteRepository.findAll();
		System.out.println(gerentes);
	}
	@Test
	void saveOrdenes(){
		Local local = localRepository.findById(1L).orElse(null);
		Orden orden1 = new Orden();
		orden1.setDescripcion("iphone 15 plus");
		orden1.setPrecio(1.2);
		orden1.setLocal(local);
		ordenRepository.save(orden1);
	}
	@Test
	void getAllOrdenes(){
		List<Orden> ordenes = ordenRepository.findAll();
		System.out.println(ordenes);
	}
}
