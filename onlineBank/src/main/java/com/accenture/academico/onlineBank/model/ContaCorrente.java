package com.accenture.academico.onlineBank.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Entity
@Table(name = "ContaCorrente")
@EnableSwagger2
public class ContaCorrente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5021588284961063763L;

	@Id
	@Column(name = "idContaCorrente")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idContaCorrente;

	@NotNull
	@Column(name = "contaCorrenteAgencia")
	@Length(min = 1, max = 3)
	private String contaCorrenteAgencia;

	@NotNull
	@Column(name = "contaCorrenteNumero")
	@Length(min = 1, max = 45)
	private String contaCorrenteNumero;

	@Column(name = "contaCorrenteSaldo", precision = 11, scale = 2)
	private Double contaCorrenteSaldo;
	
	@OneToOne
	@JoinColumn(name = "id_cliente")
	private Cliente clienteidCliente;

	@ManyToOne
	@JoinColumn(name = "agenciaidAgencia", nullable = false)
	private Agencia agenciaidAgencia;

	
	
	public Integer getIdContaCorrente() {
		return idContaCorrente;
	}

	public void setIdContaCorrente(Integer idContaCorrente) {
		this.idContaCorrente = idContaCorrente;
	}

	public String getContaCorrenteAgencia() {
		return contaCorrenteAgencia;
	}

	public void setContaCorrenteAgencia(String contaCorrenteAgencia) {
		this.contaCorrenteAgencia = contaCorrenteAgencia;
	}

	public String getContaCorrenteNumero() {
		return contaCorrenteNumero;
	}

	public void setContaCorrenteNumero(String contaCorrenteNumero) {
		this.contaCorrenteNumero = contaCorrenteNumero;
	}

	public Double getContaCorrenteSaldo() {
		return contaCorrenteSaldo;
	}

	public void setContaCorrenteSaldo(Double contaCorrenteSaldo) {
		this.contaCorrenteSaldo = contaCorrenteSaldo;
	}

	public Cliente getClienteidCliente() {
		return clienteidCliente;
	}

	public void setClienteidCliente(Cliente clienteidCliente) {
		this.clienteidCliente = clienteidCliente;
	}

	public Agencia getAgenciaidAgencia() {
		return agenciaidAgencia;
	}

	public void setAgenciaidAgencia(Agencia agenciaidAgencia) {
		this.agenciaidAgencia = agenciaidAgencia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
