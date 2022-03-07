package com.ufcg.psoft.mercadofacil.model;

public class EstrategiaCalculoComum extends EstrategiaCalculo {

	public EstrategiaCalculoComum(String tipoProdutos, double valorCompra) {
		this.tipoProdutos = tipoProdutos;
		this.fatorTransporteProdutos = 1.05;
		this.valorCompra = valorCompra;
	}
	
	@Override
	public String toString() {
		return "COMUM";
	}
	

}
