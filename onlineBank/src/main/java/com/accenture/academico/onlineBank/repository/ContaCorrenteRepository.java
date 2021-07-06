package com.accenture.academico.onlineBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accenture.academico.onlineBank.model.ContaCorrente;

@Repository
public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Integer> {

	@Modifying
	@Query(value = "update banco.conta_corrente set conta_corrente_saldo = :saldo where id_conta_corrente = :idContaCorrente", nativeQuery = true)
	void setSaldo(@Param("idContaCorrente") Integer idContaCorrente, @Param("saldo") double saldo);
	
	@Modifying
	@Query(value = "select conta_corrente_saldo from banco.conta_corrente where id_conta_corrente = :idContaCorrente", nativeQuery = true)
	Double getSaldo(@Param("idContaCorrente") Integer idContaCorrente);
	

}