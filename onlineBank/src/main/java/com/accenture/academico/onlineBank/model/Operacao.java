package com.accenture.academico.onlineBank.model;

public enum Operacao {

	SAQUE("Saque"), DEPOSITO("Deposito"), TRANSFERENCIA("Transferencia"), APORTE("Aporte"), DEBITO("Debito");
	
	private String tipoOperacao;

	private Operacao(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	
	public String getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}
	
}
