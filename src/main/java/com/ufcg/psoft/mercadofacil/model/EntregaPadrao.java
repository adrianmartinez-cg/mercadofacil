package com.ufcg.psoft.mercadofacil.model;
import javax.persistence.Entity;

@Entity
public class EntregaPadrao extends Entrega {
	
	public EntregaPadrao() {
		this.fatorFormaEntrega = 1.05;
	}
	
	public EntregaPadrao(String tipoProdutos, double valorCompra) {
		this.fatorFormaEntrega = 1.05;
		this.estrategiaCalculo = determinarEstrategia(tipoProdutos,valorCompra);
	}
	

}
