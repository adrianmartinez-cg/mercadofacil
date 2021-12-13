package com.ufcg.psoft.mercadofacil.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long CPF;
	
	private String nome;

	private Integer idade;

	private String endereco;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Carrinho carrinho;

	private Cliente() {}

	public Cliente(Long cpf, String nome, Integer idade, String endereco) {
		this.CPF = cpf;
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
		this.carrinho = new Carrinho();
	}

	public Long getId() {
		return id;
	}

	public Long getCpf() {
		return CPF;
	}

	public String getNome() {
		return nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void adicionarProdutoCarrinho(Produto produto, int quantidade) {
		this.carrinho.adicionarProduto(produto,quantidade);
	}
	public Carrinho getCarrinho() {
		return this.carrinho;
	}
	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}
	public int removerProdutoCarrinho(Produto produto, int quantidade) {
		return this.carrinho.removerProduto(produto,quantidade);
	}
}
