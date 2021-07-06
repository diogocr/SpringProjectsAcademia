package com.accenture.academico.onlineBank.model;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Extrato")
public class Extrato {

	@Id
	@Column(name = "idExtrato")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idExtrato;

	
	@Column(name = "dataHoraMovimento")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraMovimento;

	@NotNull
	@Column(name = "operacao")
	@Size(min = 1, max = 50)
	private String operacao;
	
	@NotNull
	@Column(name = "situacao")
	@Size(min = 1, max = 50)
	private String situacao;

	@Column(name = "ValorOperacao", precision = 17, scale = 2)
	private double valorOperacao;

	@Column(name = "idContaCorrente")
	private Integer idContaCorrente;

	
	
	public Extrato() {

	}

	public long getIdExtrato() {
		return idExtrato;
	}

	public void setIdExtrato(Integer idExtrato) {
		this.idExtrato = idExtrato;
	}

	public Date getDataHoraMovimento() {
		return dataHoraMovimento;
	}

	public void setDataHoraMovimento(Date dataHoraMovimento) {
		this.dataHoraMovimento = dataHoraMovimento;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	public double getValorOperacao() {
		return valorOperacao;
	}

	public void setValorOperacao(double valorOperacao) {
		this.valorOperacao = valorOperacao;
	}

	public Integer getIdContaCorrente() {
		return idContaCorrente;
	}

	public void setIdContaCorrente(Integer idContaCorrente) {
		this.idContaCorrente = idContaCorrente;
	}

}