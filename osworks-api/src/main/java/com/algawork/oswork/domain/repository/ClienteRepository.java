package com.algawork.oswork.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algawork.oswork.domain.model.Cliente;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	// Buscar lista de clientes por nome
	List<Cliente> findByNome(String nome);
	// Buscar contendo a palavra
	List<Cliente> findByNomeContaining(String nome);
	// Buscar por email
	Cliente findByEmail(String email);
}
