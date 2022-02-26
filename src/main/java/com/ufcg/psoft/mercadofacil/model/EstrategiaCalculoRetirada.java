package com.ufcg.psoft.mercadofacil.model;

public class EstrategiaCalculoRetirada extends EstrategiaCalculo {

	public EstrategiaCalculoRetirada(double valorCompra) {
		this.fatorTipoProdutos = 1;
		this.valorCompra = valorCompra;
	}
	
	@Override
	public void calculaValorEntrega() {
		this.totalAPagar = valorCompra;
	}
	
	@Override
	public String toString() {
		return "RETIRADA";
	}

}
