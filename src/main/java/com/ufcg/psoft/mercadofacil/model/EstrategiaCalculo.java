package com.ufcg.psoft.mercadofacil.model;

public abstract class EstrategiaCalculo {
	
	protected double valorCompra;
	
	protected double totalAPagar;
	
	protected double fatorTransporteProdutos;
	
	protected String tipoProdutos;
	
	public String getTipoProdutos() {
		return tipoProdutos;
	}

	public void setTipoProdutos(String tipoProdutos) {
		this.tipoProdutos = tipoProdutos;
	}
	
	public double getValorCompra() {
		return this.valorCompra;
	}
	
	public double getFatorTransporteProdutos() {
		return this.fatorTransporteProdutos;
	}

	public void definirTotalAPagar(double fatorFormaEntrega) {
		this.totalAPagar = this.valorCompra*fatorFormaEntrega*fatorTransporteProdutos;
	}
	
	public double getTotalAPagar() {
		return totalAPagar;
	}

	public void setTotalAPagar(double totalAPagar) {
		this.totalAPagar = totalAPagar;
	};

	
}
