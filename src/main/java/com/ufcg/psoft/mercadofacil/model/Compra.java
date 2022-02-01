package com.ufcg.psoft.mercadofacil.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Carrinho carrinho;
	
	private LocalDate data;
	
	private double valor;
	
	private FormaPagamento formaPagamento;
	
	public Compra() {}
	public Compra(Carrinho carrinho, double valor) {
		this.carrinho = carrinho;
		this.valor = valor;
		this.data = LocalDate.now();
	}
	
	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public Long getId() {
		return id;
	}

	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public double getValor() {
		return this.valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	public void setFormaPagamento(String formaPagamento) {
		if(formaPagamento.equals("BOLETO")) {
			setFormaPagamento(FormaPagamento.BOLETO);
		} else if (formaPagamento.equals("PAYPAL")) {
			setFormaPagamento(FormaPagamento.PAYPAL);
		} else if (formaPagamento.equals("CARTAO_DE_CREDITO")) {
			setFormaPagamento(FormaPagamento.CARTAO_DE_CREDITO);
		}
	}
}
