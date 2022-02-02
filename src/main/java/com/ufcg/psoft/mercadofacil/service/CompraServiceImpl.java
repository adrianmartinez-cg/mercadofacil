package com.ufcg.psoft.mercadofacil.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.psoft.mercadofacil.model.Carrinho;
import com.ufcg.psoft.mercadofacil.model.Cliente;
import com.ufcg.psoft.mercadofacil.model.Compra;
import com.ufcg.psoft.mercadofacil.model.FormaPagamento;
import com.ufcg.psoft.mercadofacil.repository.CompraRepository;

@Service
public class CompraServiceImpl implements CompraService{
	
	@Autowired 
	private ClienteService clienteService;
	
	@Autowired
	private CompraRepository compraRepository;

	@Override
	public void salvarCompra(Compra compra) {
		compraRepository.save(compra);
	}
	
	public Compra fecharCompra(Cliente cliente, String formaPagamento) {
		if(cliente.getCarrinho().temAlgumProduto()) {
			Compra compra = new Compra(cliente.getCarrinho(), 
					                   cliente.getCarrinho().getValor());
			compra.setFormaPagamento(formaPagamento);
			if(compra.getFormaPagamento() != null) {
				compra.calcularValorComAcrescimo();
				compra.calcularValorComDesconto(cliente.getPerfilCliente());
				salvarCompra(compra);
				cliente.adicionarCompra(compra);
				cliente.setCarrinho(new Carrinho());
				clienteService.salvarClienteCadastrado(cliente);
			}
			return compra;
		}
		return null;
	}

	@Override
	public Optional<Compra> getCompra(Long idCompra) {
		return compraRepository.findById(idCompra);
	}
	
}
