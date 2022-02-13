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

import com.ufcg.psoft.mercadofacil.model.Cliente;
import com.ufcg.psoft.mercadofacil.model.Compra;
import com.ufcg.psoft.mercadofacil.model.FormaPagamento;
import com.ufcg.psoft.mercadofacil.service.ClienteService;
import com.ufcg.psoft.mercadofacil.service.CompraService;
import com.ufcg.psoft.mercadofacil.util.ErroCliente;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class CompraApiController {
	
	@Autowired
	private CompraService compraService;
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value = "/cliente/{idCliente}/compra", method = RequestMethod.POST)
	public ResponseEntity<?>  finalizarCompra(@PathVariable("idCliente") long idCliente, @RequestBody String tipoPagamento){
		Optional<Cliente> clienteOp = clienteService.getClienteById(idCliente);
		if (!clienteOp.isPresent()) {
			return ErroCliente.erroClienteNaoEncontrado(idCliente);
		}
		Cliente cliente = clienteOp.get();
		Compra compra = compraService.fecharCompra(cliente, tipoPagamento);
		if(compra == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if(compra.getFormaPagamento() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Compra>(compra,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cliente/{idCliente}/compra/", method = RequestMethod.GET)
	public ResponseEntity<?> consultarCompra(@PathVariable ("idCliente") long idCliente, long idCompra){
		Optional<Cliente> clienteOp = clienteService.getClienteById(idCliente);
		if (!clienteOp.isPresent()) {
			return ErroCliente.erroClienteNaoEncontrado(idCliente);
		}
		Optional<Compra> compra = compraService.getCompra(idCompra);
		if(!compra.isPresent()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Cliente cliente = clienteOp.get();
		if(!clienteService.clienteTemCompra(cliente, idCompra)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Compra>(compra.get(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/pagamento", method = RequestMethod.GET)
	public ResponseEntity<?> consultarFormasPagamento(){
		return new ResponseEntity<FormaPagamento[]>(FormaPagamento.values(),HttpStatus.OK);
	}
}
