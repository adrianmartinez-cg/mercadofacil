package com.ufcg.psoft.mercadofacil.model;

public class EstrategiaCalculoRefrigeracao extends EstrategiaCalculo {
	
	public EstrategiaCalculoRefrigeracao(String tipoProdutos, double valorCompra) {
		this.tipoProdutos = tipoProdutos;
		this.fatorTransporteProdutos = 1.20;
		this.valorCompra = valorCompra;
	}
	
	@Override
	public String toString() {
		return "REFRIGERACAO";
	}
}
