package com.ufcg.psoft.mercadofacil.service;

import com.ufcg.psoft.mercadofacil.model.Cliente;
import com.ufcg.psoft.mercadofacil.model.Lote;
import com.ufcg.psoft.mercadofacil.model.Produto;

public interface CarrinhoService {
	public Lote adicionarProduto(Cliente cliente, Produto produto, int quantidade);
	public Lote removerProduto(Cliente cliente, Produto produto, int quantidade);
}
