package com.ufcg.psoft.mercadofacil.model;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.ufcg.psoft.mercadofacil.util.EstrategiaCalculoConverter;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Entrega {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	@Convert(converter = EstrategiaCalculoConverter.class)
	protected EstrategiaCalculo estrategiaCalculo;
	
	protected double fatorFormaEntrega;
	
	protected String tipoEntrega;
	
	public String getTipoEntrega() {
		return tipoEntrega;
	}

	public void setTipoEntrega(String tipoEntrega) {
		this.tipoEntrega = tipoEntrega;
	}

	public double calculaValorEntrega() {
		this.estrategiaCalculo.definirTotalAPagar(this.fatorFormaEntrega);
		return this.estrategiaCalculo.getTotalAPagar();
	}
	
	public void setEstrategiaCalculo(EstrategiaCalculo estrategiaCalculo) {
		this.estrategiaCalculo = estrategiaCalculo;
	}
	
	protected EstrategiaCalculo determinarEstrategia(String tipoProdutos, double valorCompra) {
		if(tipoProdutos.equals("COMUM")) {
			return new EstrategiaCalculoComum(tipoProdutos,valorCompra);	
		} else if (tipoProdutos.equals("FRAGIL")) {
			return new EstrategiaCalculoFragil(tipoProdutos,valorCompra);
		} else if (tipoProdutos.equals("REFRIGERACAO")) {
			return new EstrategiaCalculoRefrigeracao(tipoProdutos,valorCompra);
		} 
		return null;
	}
	
	public EstrategiaCalculo getEstrategiaCalculo() {
		return this.estrategiaCalculo;
	}
	
	public double getFatorFormaEntrega() {
		return this.fatorFormaEntrega;
	}
}
