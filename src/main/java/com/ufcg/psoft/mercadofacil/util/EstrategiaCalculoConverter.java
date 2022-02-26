package com.ufcg.psoft.mercadofacil.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.ufcg.psoft.mercadofacil.model.EstrategiaCalculo;
import com.ufcg.psoft.mercadofacil.model.EstrategiaCalculoComum;
import com.ufcg.psoft.mercadofacil.model.EstrategiaCalculoFragil;
import com.ufcg.psoft.mercadofacil.model.EstrategiaCalculoRefrigeracao;
import com.ufcg.psoft.mercadofacil.model.EstrategiaCalculoRetirada;


@Converter
public class EstrategiaCalculoConverter implements  AttributeConverter<EstrategiaCalculo, String>{

	@Override
	public String convertToDatabaseColumn(EstrategiaCalculo estrategia) {
		return estrategia.toString();
	}

	@Override
	public EstrategiaCalculo convertToEntityAttribute(String dbData) {
		if(dbData.equals("RETIRADA")) {
			return new EstrategiaCalculoRetirada(0,"");
		} else if (dbData.equals("COMUM")) {
			return new EstrategiaCalculoComum(0,"");
		} else if (dbData.equals("FRAGIL")) {
			return new EstrategiaCalculoFragil(0,"");
		} else if (dbData.equals("REFRIGERACAO")) {
			return new EstrategiaCalculoRefrigeracao(0,"");
		}
		return null;
	}

}
