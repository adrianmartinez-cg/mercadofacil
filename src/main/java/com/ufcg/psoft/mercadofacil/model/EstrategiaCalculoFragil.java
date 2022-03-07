package com.ufcg.psoft.mercadofacil.model;

public class EstrategiaCalculoFragil extends EstrategiaCalculo {
	
	public EstrategiaCalculoFragil(String tipoProdutos, double valorCompra) {
		this.tipoProdutos = tipoProdutos;
		this.fatorTransporteProdutos = 1.15;
		this.valorCompra = valorCompra;
	}

	@Override
	public String toString() {
		return "FRAGIL";
	}
}
