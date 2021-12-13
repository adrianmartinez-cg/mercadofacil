package com.ufcg.psoft.mercadofacil.service;

import com.ufcg.psoft.mercadofacil.model.Cliente;
import com.ufcg.psoft.mercadofacil.model.Compra;

public interface CompraService {
	
	public void salvarCompra(Compra compra);
	public Compra fecharCompra(Cliente cliente);

}
