package com.ufcg.psoft.mercadofacil.model;

public class EstrategiaCalculoComum extends EstrategiaCalculo {

	public EstrategiaCalculoComum(double valorCompra, String tipoProdutos) {
		this.tipoProdutos = tipoProdutos;
		this.fatorTipoProdutos = 1.05;
		this.valorCompra = valorCompra;
	}
	
	@Override
	public void calculaValorEntrega() {
		this.totalAPagar = valorCompra*fatorTipoProdutos;
	}

	@Override
	public String toString() {
		return "COMUM";
	}
	

}
