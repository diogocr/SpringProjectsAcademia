package com.accenture.academico.onlineBank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.academico.onlineBank.exception.RegraNegocioException;
import com.accenture.academico.onlineBank.model.Extrato;
import com.accenture.academico.onlineBank.repository.ExtratoRepository;

@Service
public class ExtratoService {

	@Autowired
	ExtratoRepository extratoRepository;
	@Autowired
	ContaCorrenteService ccService;


	public Extrato getExtratoById(int id) {
		return extratoRepository.findById((Integer) id).get();
	}

	public List<Extrato> getExtratoByContaCorrenteId(int id) {
		return extratoRepository.findByContaCorrenteId(id);
	}

	
	public void saveOrUpdate(Extrato extrato) throws RegraNegocioException {

		if (ccService.buscar(extrato.getIdContaCorrente()) != null) {
			if (extrato.getOperacao().equals("Saque") 
					|| extrato.getOperacao().equals("Deposito")
					|| extrato.getOperacao().equals("Transferencia")) {

				extratoRepository.save(extrato);

			} else {
				throw new RegraNegocioException("Operacao invalida!");
			}
		} else {
			throw new RegraNegocioException("Conta corrente inexistente!");
		}

	}

	public void delete(int id) {
		extratoRepository.deleteById((Integer) id);
	}

}