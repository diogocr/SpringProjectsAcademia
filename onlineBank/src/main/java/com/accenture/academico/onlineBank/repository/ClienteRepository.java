package com.accenture.academico.onlineBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.academico.onlineBank.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> { 
	
}
