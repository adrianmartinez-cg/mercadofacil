package com.ufcg.psoft.mercadofacil.model;
import javax.persistence.Entity;

@Entity
public class EntregaRetirada extends Entrega {
	
	public EntregaRetirada() {
		this.fatorFormaEntrega = 1;
	}
	
	public EntregaRetirada(String tipoProdutos, double valorCompra) {
		this.fatorFormaEntrega = 1;
		this.estrategiaCalculo = new EstrategiaCalculoRetirada(valorCompra,tipoProdutos);
	}

}
