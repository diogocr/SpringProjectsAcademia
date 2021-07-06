package com.accenture.academico.onlineBank.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.accenture.academico.onlineBank.exception.RegraNegocioException;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Agencia")
public class Agencia implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4067083770027756034L;

	@Id
	@Column(name = "idAgencia")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idAgencia;

	@NotNull
	@Column(name = "nomeAgencia")
	@Length(min = 3, max = 45)
	private String nomeAgencia;

	@NotNull
	@Column(name = "endereco")
	@Length(min = 4, max = 45)
	private String endereco;

	@NotNull
	@Column(name = "telefone")
	@Length(min = 8, max = 15)
	private String telefone;

	@OneToMany(mappedBy = "agenciaidAgencia")
	@JsonIgnore
	private List<ContaCorrente> contas;

	public Integer getIdAgencia() {
		return idAgencia;
	}

	public void setIdAgencia(Integer idAgencia) {
		this.idAgencia = idAgencia;
	}

	public String getNomeAgencia() {
		return nomeAgencia;
	}

	public void setNomeAgencia(String nomeAgencia) throws RegraNegocioException {
		if (nomeAgencia.isEmpty()) {
			throw new RegraNegocioException("O nome da agência não foi informado.");
		} else {

			this.nomeAgencia = nomeAgencia;
		}
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) throws RegraNegocioException {
		if (endereco.isEmpty()) {
			throw new RegraNegocioException("O endereço da agência não foi informado.");
		} else {

			this.endereco = endereco;
		}
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) throws RegraNegocioException {
		if (telefone.isEmpty()) {
			throw new RegraNegocioException("O telefone da agência não foi informado.");
		} else {
			this.telefone = telefone;
		}
	}

}
