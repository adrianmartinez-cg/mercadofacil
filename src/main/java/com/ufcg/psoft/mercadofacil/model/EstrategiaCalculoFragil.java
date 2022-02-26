package com.ufcg.psoft.mercadofacil.model;

public class EstrategiaCalculoFragil extends EstrategiaCalculo {
	
	public EstrategiaCalculoFragil(double valorCompra) {
		this.fatorTipoProdutos = 1.15;
		this.valorCompra = valorCompra;
	}

	@Override
	public void calculaValorEntrega() {
		this.totalAPagar = valorCompra*fatorTipoProdutos;
	}

	@Override
	public String toString() {
		return "FRAGIL";
	}
}
