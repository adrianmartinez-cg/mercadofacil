package com.ufcg.psoft.mercadofacil.model;

public class EstrategiaCalculoRetirada extends EstrategiaCalculo {

	public EstrategiaCalculoRetirada(String tipoProdutos, double valorCompra) {
		this.tipoProdutos = tipoProdutos;
		this.fatorTransporteProdutos = 1;
		this.valorCompra = valorCompra;
	}
	
	@Override
	public String toString() {
		return "RETIRADA";
	}

}
