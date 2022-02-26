package com.ufcg.psoft.mercadofacil.model;

public class EstrategiaCalculoRefrigeracao extends EstrategiaCalculo {
	
	public EstrategiaCalculoRefrigeracao(double valorCompra, String tipoProdutos) {
		this.tipoProdutos = tipoProdutos;
		this.fatorTipoProdutos = 1.20;
		this.valorCompra = valorCompra;
	}
	
	@Override
	public void calculaValorEntrega() {
		this.totalAPagar = valorCompra*fatorTipoProdutos;
	}

	@Override
	public String toString() {
		return "REFRIGERACAO";
	}
}
