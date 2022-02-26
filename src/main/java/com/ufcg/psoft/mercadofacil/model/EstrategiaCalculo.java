package com.ufcg.psoft.mercadofacil.model;

public abstract class EstrategiaCalculo {
	
	protected double valorCompra;
	
	protected double totalAPagar;
	
	protected double fatorTipoProdutos;
	
	public abstract void calculaValorEntrega();
	
	public abstract String toString();
	
	public double getValorCompra() {
		return this.valorCompra;
	}
	
	public double getFatorTipoProdutos() {
		return this.fatorTipoProdutos;
	}

	public void definirTotalAPagar(double fatorEntrega) {
		this.totalAPagar = this.valorCompra*fatorEntrega*fatorTipoProdutos;
	}
	
	public double getTotalAPagar() {
		return totalAPagar;
	}

	public void setTotalAPagar(double totalAPagar) {
		this.totalAPagar = totalAPagar;
	};

	
}
