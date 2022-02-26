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
	
	public Compra fecharCompra(Cliente cliente, String formaPagamento, String formaEntrega) {
		if(cliente.temAlgumProduto()) {
			Compra compra = new Compra(cliente.getCarrinho(), 
					                   cliente.getValorCarrinho());
			compra.definirFormaPagamento(formaPagamento);
			if(detalhesCompraValidos(compra,formaEntrega)) {
				compra.calcularValorComAcrescimo();
				compra.calcularValorComDesconto(cliente.getPerfilCliente());
				compra.definirFormaEntrega(formaEntrega,getTipoProdutos(cliente.getCarrinho()),compra.getValorComDesconto());
				compra.definirTotalAPagar();
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
	
	private String getTipoProdutos(Carrinho carrinho) {
		return carrinho.getTipoProdutos();
	}
	
	private boolean formaEntregaValida(String formaEntrega) {
		return formaEntrega.equals("RETIRADA") || formaEntrega.equals("PADRAO") || formaEntrega.equals("EXPRESS");
	}
	
	private boolean detalhesCompraValidos(Compra compra, String formaEntrega) {
		return (compra.getFormaPagamento() != null) && formaEntregaValida(formaEntrega); 
	}
	
}
