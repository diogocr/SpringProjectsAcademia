package com.accenture.academico.onlineBank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.accenture.academico.onlineBank.exception.RegraNegocioException;
import com.accenture.academico.onlineBank.service.ClienteService;

@Entity
@Table(name = "cliente" )
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idCliente;
	
	@Column(name ="ClienteNome", nullable = false)
    private String clienteNome;
	
	@Column(name = "ClienteCPF", nullable = false)
    private String clienteCpf;
	
	@Column(name = "ClienteFone")
    private String clienteFone;

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getClienteNome() {
		return clienteNome;
	}

	public void setClienteNome(String clienteNome) throws RegraNegocioException {
		if(clienteNome.isEmpty()) {
			throw new RegraNegocioException("O nome passado não pode ser vazio.");
		} 
		this.clienteNome = clienteNome;
	}
	
	public String getClienteCpf() {
		return clienteCpf;
	}

	public void setClienteCpf(String clienteCpf) throws RegraNegocioException{
		if(clienteCpf.length() > 14) {
			throw new RegraNegocioException("O CPF tem mais que 14 caracteres");
		} else if(ClienteService.isCPF(clienteCpf) == false) {
			throw new RegraNegocioException("O CPF é inválido");
		} 
		this.clienteCpf = clienteCpf;
	}

	public String getClienteFone() {
		return clienteFone;
	}

	public void setClienteFone(String clienteFone) throws RegraNegocioException {
		if(clienteFone.isEmpty()) {
			throw new RegraNegocioException("O telefone passado não pode ser vazio");
		} 
		this.clienteFone = clienteFone;
	}
	
}
