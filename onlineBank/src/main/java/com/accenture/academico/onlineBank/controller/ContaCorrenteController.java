package com.accenture.academico.onlineBank.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.academico.onlineBank.exception.ContaInvalidaException;
import com.accenture.academico.onlineBank.exception.OperacaoInvalidaException;
import com.accenture.academico.onlineBank.exception.RegraNegocioException;
import com.accenture.academico.onlineBank.model.ContaCorrente;
import com.accenture.academico.onlineBank.service.ContaCorrenteService;

@RestController
@RequestMapping("/contas")
@Transactional
public class ContaCorrenteController {

	@Autowired
	private ContaCorrenteService contaCorrenteService;

	@GetMapping("/listar")
	public List<ContaCorrente> listar() {
		return contaCorrenteService.listarContas();
	}

	@GetMapping("/buscar/{id}")
	public ContaCorrente buscar(@PathVariable("id") Integer id) {
		return contaCorrenteService.buscar(id);
	}

	@PostMapping("/adicionar")
	public ContaCorrente adiciona(@Valid @RequestBody ContaCorrente contaCorrente) {
		return contaCorrenteService.adicionarOuAtualizar(contaCorrente);
	}

	@DeleteMapping("/remover/{id}")
	public void remover(@PathVariable("id") Integer id) {
		contaCorrenteService.remover(id);
	}

	@PutMapping("/atualizar/{id}")
	public ContaCorrente atualizar(@RequestBody ContaCorrente contaCorrente) {
		return contaCorrenteService.adicionarOuAtualizar(contaCorrente);
	}

	@PostMapping("/sacar/{idConta}/{valor}")
	public void sacar(@PathVariable("idConta") Integer idContaOrigem, @PathVariable("valor") double valor)
			throws RegraNegocioException {
		contaCorrenteService.sacar(valor, idContaOrigem);
	}

	@PostMapping("/depositar/{idConta}/{valor}")
	public void deposito(@PathVariable("valor") double valor, @PathVariable("idConta") Integer idContaOrigem)
			throws RegraNegocioException {
		contaCorrenteService.depositar(valor, idContaOrigem);
	}

	@PostMapping("/realizarTransferencia/{idContaOrigem}/{idContaDestino}/{valor}")
	public void transferir(@PathVariable("idContaOrigem") Integer idContaOrigem, 
			@PathVariable("idContaDestino") Integer idContadestino, @PathVariable("valor") double valor) throws RegraNegocioException {
		contaCorrenteService.transferir(idContaOrigem ,idContadestino, valor);
	}
}