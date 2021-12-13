package com.ufcg.psoft.mercadofacil.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ufcg.psoft.mercadofacil.model.Carrinho;
import com.ufcg.psoft.mercadofacil.model.Cliente;
import com.ufcg.psoft.mercadofacil.model.Lote;
import com.ufcg.psoft.mercadofacil.model.Produto;
import com.ufcg.psoft.mercadofacil.service.CarrinhoService;
import com.ufcg.psoft.mercadofacil.service.ClienteService;
import com.ufcg.psoft.mercadofacil.service.LoteService;
import com.ufcg.psoft.mercadofacil.service.ProdutoService;
import com.ufcg.psoft.mercadofacil.util.ErroCliente;
import com.ufcg.psoft.mercadofacil.util.ErroProduto;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CarrinhoApiController {
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	ProdutoService produtoService;
	
	@Autowired
	CarrinhoService carrinhoService;
	
	@Autowired
	LoteService loteService;
	
	@RequestMapping(value = "/cliente/{idCliente}/carrinho/add", method = RequestMethod.PUT)
	public ResponseEntity<?> adicionarProduto(@PathVariable("idCliente") long idCliente, @RequestBody Long idProduto, 
							  int quantidade) {
		
		Optional<Cliente> clienteOp = clienteService.getClienteById(idCliente);
		if (!clienteOp.isPresent()) {
			return ErroCliente.erroClienteNaoEncontrado(idCliente);
		}
		
		Optional<Produto> produtoOp = produtoService.getProdutoById(idProduto);
		if (!produtoOp.isPresent()) {
			return ErroProduto.erroProdutoNaoEncontrado(idProduto);
		}
		if (!produtoOp.get().isDisponivel()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Lote lote = carrinhoService.adicionarProduto(clienteOp.get(), produtoOp.get(),quantidade);
		if(lote.getNumeroDeItens() >= 0) {
			loteService.salvarLote(lote);
			return new ResponseEntity<Lote>(lote,HttpStatus.OK);
		}
		lote.setNumeroDeItens(lote.getNumeroDeItens() + quantidade);
		loteService.salvarLote(lote);
		return new ResponseEntity<Lote>(lote,HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/cliente/{idCliente}/carrinho/remove", method = RequestMethod.PUT)
	public ResponseEntity<?> removerProduto(@PathVariable("idCliente") long idCliente, @RequestBody Long idProduto,
							 int quantidade) {
		
		Optional<Cliente> clienteOp = clienteService.getClienteById(idCliente);
		if (!clienteOp.isPresent()) {
			return ErroCliente.erroClienteNaoEncontrado(idCliente);
		}
		
		Optional<Produto> produtoOp = produtoService.getProdutoById(idProduto);
		if (!produtoOp.isPresent()) {
			return ErroProduto.erroProdutoNaoEncontrado(idProduto);
		}
		if(!clienteOp.get().getCarrinho().temProduto(idProduto)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Lote lote = carrinhoService.removerProduto(clienteOp.get(), produtoOp.get(),quantidade);
		loteService.salvarLote(lote);
		return new ResponseEntity<Lote>(lote,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cliente/{idCliente}/carrinho/", method = RequestMethod.GET)
	public ResponseEntity<?> listarProdutosCarrinho(@PathVariable("idCliente") long idCliente){
		Optional<Cliente> clienteOp = clienteService.getClienteById(idCliente);
		if (!clienteOp.isPresent()) {
			return ErroCliente.erroClienteNaoEncontrado(idCliente);
		}
		return new ResponseEntity<Carrinho>(clienteOp.get().getCarrinho(),HttpStatus.OK);
	}
	
}
