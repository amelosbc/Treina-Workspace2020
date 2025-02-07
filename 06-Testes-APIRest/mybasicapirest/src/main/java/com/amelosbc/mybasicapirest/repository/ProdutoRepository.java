package com.amelosbc.mybasicapirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amelosbc.mybasicapirest.models.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Long>{

	Produto findById (long id);
}
