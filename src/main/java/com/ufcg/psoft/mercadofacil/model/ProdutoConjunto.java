package com.ufcg.psoft.mercadofacil.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ProdutoConjunto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Produto produto;

	private int quantidade;
	
	public ProdutoConjunto() {
		
	}
	public ProdutoConjunto(Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public Long getProdutoId() {
		return produto.getId();
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int diminuirQuantidade(int quantidade) {
		int removidos = 0;
		if(this.quantidade - quantidade >= 0) {
			this.quantidade -= quantidade;
			removidos = quantidade;
		} else {
			removidos = this.quantidade;
			setQuantidade(0);
		}
		return removidos;
	}
	
	public void aumentarQuantidade(int quantidade) {
		this.quantidade += quantidade;
	}
	
	public boolean estaVazio() {
		return this.quantidade == 0;
	}
	
	public double getValor() {
		return produto.getPreco().doubleValue()*quantidade;
	}
	
	

}
