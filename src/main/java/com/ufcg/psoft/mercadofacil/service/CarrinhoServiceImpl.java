package com.ufcg.psoft.mercadofacil.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.psoft.mercadofacil.model.Cliente;
import com.ufcg.psoft.mercadofacil.model.Lote;
import com.ufcg.psoft.mercadofacil.model.Produto;
import com.ufcg.psoft.mercadofacil.repository.CarrinhoRepository;

@Service
public class CarrinhoServiceImpl implements CarrinhoService{
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	ProdutoService produtoService;
	
	@Autowired
	LoteService loteService;
	
	@Autowired
	CarrinhoRepository carrinhoRepository;
	
	@Override
	public Lote adicionarProduto(Cliente cliente, Produto produto, int quantidade) {
		Lote lote = loteService.getLoteByProdutoId(produto.getId());
		int numItens = lote.getNumeroDeItens();
		if(numItens - quantidade >= 0) {
			cliente.adicionarProdutoCarrinho(produto,quantidade);
			clienteService.salvarClienteCadastrado(cliente);
			carrinhoRepository.save(cliente.getCarrinho());
		}
		lote.setNumeroDeItens(numItens - quantidade);
		return lote;
	}

	@Override
	public Lote removerProduto(Cliente cliente, Produto produto, int quantidade) {
		Lote lote = loteService.getLoteByProdutoId(produto.getId());
		int removidos = cliente.removerProdutoCarrinho(produto,quantidade);
		clienteService.salvarClienteCadastrado(cliente);
		carrinhoRepository.save(cliente.getCarrinho());
		lote.setNumeroDeItens(lote.getNumeroDeItens() + removidos);		
		return lote;
	}
	
}
