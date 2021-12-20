package com.ufcg.psoft.mercadofacil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.psoft.mercadofacil.model.ProdutoConjunto;
import com.ufcg.psoft.mercadofacil.repository.ProdutoConjuntoRepository;

@Service
public class ProdutoConjuntoServiceImpl implements ProdutoConjuntoService{

	@Autowired
	private ProdutoConjuntoRepository produtoConjuntoRepository;

	@Override
	public void salvarConjunto(ProdutoConjunto produtoConjunto) {
		produtoConjuntoRepository.save(produtoConjunto);
	}
	
}
