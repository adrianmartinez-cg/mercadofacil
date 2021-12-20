package com.ufcg.psoft.mercadofacil.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufcg.psoft.mercadofacil.model.Compra;

public interface CompraRepository extends JpaRepository <Compra,Long>{
	public Optional<Compra> findById(Long id);
}
