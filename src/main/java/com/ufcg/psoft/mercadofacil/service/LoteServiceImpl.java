package com.ufcg.psoft.mercadofacil.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.psoft.mercadofacil.model.Lote;
import com.ufcg.psoft.mercadofacil.model.Produto;
import com.ufcg.psoft.mercadofacil.repository.LoteRepository;

@Service
public class LoteServiceImpl implements LoteService {
	
	@Autowired
	private LoteRepository loteRepository;
	
	public List<Lote> listarLotes() {
		return loteRepository.findAll();
	}

	public void salvarLote(Lote lote) {
		loteRepository.save(lote);		
	}

	public Lote criaLote(int numItens, Produto produto) {
		Lote lote = new Lote(produto, numItens);
		return lote;
	}

	@Override
	public Optional<Lote> getLoteById(Long idLote) {
		return loteRepository.findById(idLote);
	}
	
	public Lote getLoteByProdutoId(Long idProduto) {
		List<Lote> lotes = listarLotes();
		for(Lote lote : lotes) {
			Produto produto = lote.getProduto();
			if(produto.getId() == idProduto) {
				return lote;
			}
		}
		return null;
	}
	
}
