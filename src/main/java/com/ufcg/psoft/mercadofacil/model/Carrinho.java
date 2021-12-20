package com.ufcg.psoft.mercadofacil.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Carrinho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name="carrinho_id")
	private List<ProdutoConjunto> produtos;
	
	public Carrinho() {
		this.produtos = new ArrayList<ProdutoConjunto>();
	}
	public List<ProdutoConjunto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoConjunto> produtos) {
		this.produtos = produtos;
	}
	
	public void adicionarProduto(Produto produto , int quantidade) {
		Long idProduto = produto.getId();
		boolean adicionouAntes = false;
		for(ProdutoConjunto conjunto : this.produtos) {
			if(conjunto.getProdutoId().equals(idProduto)) {
				conjunto.aumentarQuantidade(quantidade);
				adicionouAntes = true;
				break;
			}
		}
		if(!adicionouAntes) {
			ProdutoConjunto conjunto = new ProdutoConjunto(produto,quantidade);
			this.produtos.add(conjunto);
		}
	}
	
	public int removerProduto(Produto produto, int quantidade) {
		int removidos = 0;
		for(ProdutoConjunto conjunto : this.produtos) {
			if(conjunto.getProdutoId().equals(produto.getId())) {
				removidos = conjunto.diminuirQuantidade(quantidade);
				if(conjunto.estaVazio()) {
					produtos.remove(conjunto);
				}
				return removidos;
			}
		}
		return removidos;
	}
	
	public boolean temProduto(Long idProduto) {
		for(ProdutoConjunto conjunto : this.produtos) {
			if(conjunto.getProdutoId().equals(idProduto)) {
					return true;
			}
		}
		return false;
	}		
	
	public double getValor() {
		double valorTotal = 0;
		for(ProdutoConjunto conjunto : produtos) {
			valorTotal += conjunto.getValor();
		}
		return valorTotal;
	}
	
	public boolean temAlgumProduto() {
		return !produtos.isEmpty();
	}
	
	public Long getId() {
		return this.id;
	}
}

