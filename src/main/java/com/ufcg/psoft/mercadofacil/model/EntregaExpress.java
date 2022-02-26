package com.ufcg.psoft.mercadofacil.model;

import javax.persistence.Entity;

@Entity
public class EntregaExpress extends Entrega {

	public EntregaExpress() {
		this.fatorFormaEntrega = 1.1;
	}
	public EntregaExpress(String tipoProdutos, double valorCompra) {
		this.fatorFormaEntrega = 1.1;
		this.estrategiaCalculo = determinarEstrategia(tipoProdutos,valorCompra);
	}
}
