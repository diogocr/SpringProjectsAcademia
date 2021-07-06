package com.accenture.academico.onlineBank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.academico.onlineBank.exception.RegraNegocioException;
import com.accenture.academico.onlineBank.model.ContaCorrente;
import com.accenture.academico.onlineBank.model.Extrato;
import com.accenture.academico.onlineBank.model.Operacao;
import com.accenture.academico.onlineBank.repository.ContaCorrenteRepository;

@Service
@Transactional
public class ContaCorrenteService {

	@Autowired
	ContaCorrenteRepository contaCorrenteRepository;
	
	@Autowired
	ExtratoService extratoService;

	public List<ContaCorrente> listarContas() {
		List<ContaCorrente> contas = new ArrayList<>();
		contaCorrenteRepository.findAll().forEach(conta -> contas.add(conta));
		return contas;
	}

	public ContaCorrente buscar(Integer id) {
		return contaCorrenteRepository.findById(id).get();
	}

	public ContaCorrente adicionarOuAtualizar(ContaCorrente contaCorrente) {
		return contaCorrenteRepository.save(contaCorrente);
	}

	public void remover(Integer id) {
		contaCorrenteRepository.deleteById(id);
	}

	@Transactional
	public void sacar(double valor, Integer contaCorrentId) throws RegraNegocioException {
		ContaCorrente conta = contaCorrenteRepository.findById(contaCorrentId).get();
		double valor_final = conta.getContaCorrenteSaldo() - valor;
		
		if (valor_final > 0) {
			contaCorrenteRepository.setSaldo(contaCorrentId, valor_final);
			Extrato extratoConta = new Extrato();
			extratoConta.setIdContaCorrente(contaCorrentId);
			extratoConta.setOperacao(Operacao.SAQUE.getTipoOperacao());
			extratoConta.setSituacao(Operacao.DEBITO.getTipoOperacao());
			extratoConta.setValorOperacao(valor);
			extratoConta.setIdExtrato(contaCorrentId);
			extratoService.saveOrUpdate(extratoConta);
		} else {
			throw new RegraNegocioException("Saldo insuficiente");
		}

	}

	@Transactional
	public void depositar(double valor, Integer contaCorrentId) throws RegraNegocioException {
		ContaCorrente conta = contaCorrenteRepository.findById(contaCorrentId).get();
		double valor_final = conta.getContaCorrenteSaldo() + valor;
		
		if (valor > 0) {
			contaCorrenteRepository.setSaldo(contaCorrentId, valor_final);
			Extrato extratoConta = new Extrato();
			extratoConta.setIdContaCorrente(contaCorrentId);
			extratoConta.setOperacao(Operacao.DEPOSITO.getTipoOperacao());
			extratoConta.setSituacao(Operacao.APORTE.getTipoOperacao());
			extratoConta.setValorOperacao(valor);
			extratoConta.setIdExtrato(contaCorrentId);
			extratoService.saveOrUpdate(extratoConta);
		} else {
			throw new RegraNegocioException("Valor invalido");
		}

	}

	@Transactional
	public void transferir(Integer idContaOrigem, Integer idContaDestino, Double valor)
			throws RegraNegocioException {
		try {
			ContaCorrente contaOrigem = contaCorrenteRepository.findById(idContaOrigem).get();
			ContaCorrente contaDestino = contaCorrenteRepository.findById(idContaDestino).get();
			
			double saldo_origem = contaOrigem.getContaCorrenteSaldo();
			double saldo_destino = contaDestino.getContaCorrenteSaldo();
			
			contaOrigem.setContaCorrenteSaldo(saldo_origem - valor);
			Extrato extratoContaOrigem = new Extrato();
			extratoContaOrigem.setIdContaCorrente(idContaOrigem);
			extratoContaOrigem.setOperacao(Operacao.TRANSFERENCIA.getTipoOperacao());
			extratoContaOrigem.setSituacao(Operacao.DEBITO.getTipoOperacao());
			extratoContaOrigem.setValorOperacao(valor);
			extratoContaOrigem.setIdExtrato(idContaOrigem);
			extratoService.saveOrUpdate(extratoContaOrigem);
			
			contaDestino.setContaCorrenteSaldo(saldo_destino + valor);
			Extrato extratoContaDestino = new Extrato();
			extratoContaDestino.setIdContaCorrente(idContaDestino);
			extratoContaDestino.setOperacao(Operacao.TRANSFERENCIA.getTipoOperacao());
			extratoContaDestino.setSituacao(Operacao.APORTE.getTipoOperacao());
			extratoContaDestino.setValorOperacao(valor);
			extratoContaDestino.setIdExtrato(idContaDestino);
			extratoService.saveOrUpdate(extratoContaDestino);

		} catch (Exception e) {
			throw new RegraNegocioException("Conta Inválida.");
		}
	}

}

