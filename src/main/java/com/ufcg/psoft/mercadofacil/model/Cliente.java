package com.ufcg.psoft.mercadofacil.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	private PerfilCliente perfil;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Carrinho carrinho;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Compra> historicoCompras;

	private Cliente() {}

	public Cliente(Long cpf, String nome, Integer idade, String endereco, String perfil) {
		this.CPF = cpf;
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
		this.carrinho = new Carrinho();
		this.historicoCompras = new ArrayList<Compra>();
		setPerfilCliente(perfil);
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
	
	public void adicionarCompra(Compra compra) {
		this.historicoCompras.add(compra);
	}
	
	public List<Compra> getHistoricoCompras(){
		return this.historicoCompras;
	}
	
	public boolean temCompra(Long idCompra) {
		for(Compra compra : historicoCompras) {
			if(compra.getId().equals(idCompra)) {
				return true;
			}
		}
		return false;
	}
	
	public PerfilCliente getPerfilCliente() {
		return this.perfil;
	}
	
	public void setPerfilCliente(String perfil) {
		if(perfil.equals("NORMAL")) {
			this.perfil = PerfilCliente.NORMAL;
		} else if (perfil.equals("ESPECIAL")){
			this.perfil = PerfilCliente.ESPECIAL;
		} else if (perfil.equals("PREMIUM")) {
			this.perfil = PerfilCliente.PREMIUM;
		} else {
			this.perfil = PerfilCliente.NORMAL;
		}
	}
	
	public boolean temProdutoNoCarrinho(Long idProduto) {
		return this.carrinho.temProduto(idProduto);
	}
	
	public boolean temAlgumProduto() {
		return this.carrinho.temAlgumProduto();
	}
	
	public double getValorCarrinho() {
		return this.carrinho.getValor();
	}
}
