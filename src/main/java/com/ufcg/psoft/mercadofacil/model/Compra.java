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
	
	private double valorComAcrescimo;
	
	private double valorComDesconto;
	
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
	
	public double getValorComAcrescimo() {
		return this.valorComAcrescimo;
	}
	
	public double getValorComDesconto() {
		return this.valorComDesconto;
	}
	
	public void setValorComAcrescimo(double valorComAcrescimo) {
		this.valorComAcrescimo = valorComAcrescimo;
	}
	
	public void calcularValorComAcrescimo() {
		double valorAcrescimoPaypal = 1.02;
		double valorAcrescimoCartao = 1.05;
		if(this.formaPagamento.equals(FormaPagamento.BOLETO)) {
			setValorComAcrescimo(this.valor);
		} else if (this.formaPagamento.equals(FormaPagamento.PAYPAL)) {
			setValorComAcrescimo(this.valor*valorAcrescimoPaypal);
		} else if (this.formaPagamento.equals(FormaPagamento.CARTAO_DE_CREDITO)) {
			setValorComAcrescimo(this.valor*valorAcrescimoCartao);
		}
	}
	
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	public void definirFormaPagamento(String formaPagamento) {
		if(formaPagamento.equals("BOLETO")) {
			setFormaPagamento(FormaPagamento.BOLETO);
		} else if (formaPagamento.equals("PAYPAL")) {
			setFormaPagamento(FormaPagamento.PAYPAL);
		} else if (formaPagamento.equals("CARTAO_DE_CREDITO")) {
			setFormaPagamento(FormaPagamento.CARTAO_DE_CREDITO);
		}
	}
	
	public void calcularValorComDesconto(PerfilCliente perfilCliente) {
		if(condicaoDeDescontoPerfilEspecial(perfilCliente)) {
			this.valorComDesconto = this.valorComAcrescimo * 0.90;
		} else if (condicaoDeDescontoPerfilPremium(perfilCliente)) {
			this.valorComDesconto = this.valorComAcrescimo * 0.90;
		} else {
			this.valorComDesconto = this.valorComAcrescimo;
		}
	}
	
	private boolean condicaoDeDescontoPerfilEspecial(PerfilCliente perfilCliente) {
		return perfilCliente.equals(PerfilCliente.ESPECIAL) && this.carrinho.getQuantidadeProdutos() > 10;
	}
	
	private boolean condicaoDeDescontoPerfilPremium(PerfilCliente perfilCliente) {
		return perfilCliente.equals(PerfilCliente.PREMIUM) && this.carrinho.getQuantidadeProdutos() > 5;
	}
}
