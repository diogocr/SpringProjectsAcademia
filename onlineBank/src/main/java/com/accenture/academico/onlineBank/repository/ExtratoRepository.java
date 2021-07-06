package com.accenture.academico.onlineBank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.accenture.academico.onlineBank.model.Extrato;

@Repository
public interface ExtratoRepository extends JpaRepository<Extrato, Integer> { 
	
   @Query(value = "SELECT * FROM banco.extrato where id_conta_corrente = :idContaCorrente", 
		        nativeQuery=true
		    )
		    public List<Extrato> findByContaCorrenteId(Integer idContaCorrente);
	  
}