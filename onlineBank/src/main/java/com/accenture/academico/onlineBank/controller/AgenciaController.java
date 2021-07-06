package com.accenture.academico.onlineBank.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.academico.onlineBank.model.Agencia;
import com.accenture.academico.onlineBank.service.AgenciaService;

@RestController
@RequestMapping ("/agencias")
public class AgenciaController {
	
	@Autowired
    private AgenciaService agenciaService;

	@GetMapping ("/listar")
	public List <Agencia> listaDeAgencias(){
		return agenciaService.listarAgencias();
	}
	
	@GetMapping ("/buscar/{id}")
	public Agencia buscarAgencia(@PathVariable ("id") Integer id){
		return agenciaService.buscarAgenciaPeloId(id);
	}
	
	@PostMapping ("/adicionar")
	public Agencia adicionarAgencia(@Valid @RequestBody Agencia agencia){
		return agenciaService.salvarOuAtualizarAgencia(agencia);
	}
	
	@PutMapping ("/atualizar")
	public Agencia atualizarAgencia (@RequestBody Agencia agencia) {
		return agenciaService.salvarOuAtualizarAgencia(agencia);
	}
	
	@DeleteMapping ("/deletar/{id}")
	public void deleteAgencia (@PathVariable ("id") Integer id){
		agenciaService.deletarAgencia(id);
	}
}
