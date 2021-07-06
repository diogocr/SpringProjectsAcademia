package com.accenture.academico.onlineBank.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.academico.onlineBank.model.Agencia;
import com.accenture.academico.onlineBank.repository.AgenciaRepository;

@Service
@Transactional
public class AgenciaService {

	@Autowired
	AgenciaRepository agenciaRepository;
	
	public List<Agencia> listarAgencias() {
		List<Agencia> agencias = new ArrayList<>();
		agenciaRepository.findAll().forEach(agencia -> agencias.add(agencia));
		return agencias;
	}
	
	public Agencia buscarAgenciaPeloId(Integer id) {
		return agenciaRepository.findById(id).get();
	}
	
	public Agencia salvarOuAtualizarAgencia(Agencia agencia) {
		return agenciaRepository.save(agencia);
	}
	
	public void deletarAgencia (Integer id) {
		agenciaRepository.deleteById(id);
	}
	
}
