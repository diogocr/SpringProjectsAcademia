package com.accenture.academico.onlineBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.academico.onlineBank.model.Agencia;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Integer> { 

}
