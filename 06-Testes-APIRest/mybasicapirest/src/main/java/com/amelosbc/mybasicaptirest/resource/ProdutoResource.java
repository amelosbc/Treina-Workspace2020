package com.amelosbc.mybasicaptirest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amelosbc.mybasicapirest.models.Produto;
import com.amelosbc.mybasicapirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@ApiOperation(value="Retorna uma lista de Produtos")
	@GetMapping("/produtos")
	@RequestMapping(value = "/produtos", method = RequestMethod.GET, produces="application/json")
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
	}
	
	@ApiOperation(value="Retorna um Produto de uma Lista")
	@GetMapping("/produto/{id}")
	public Produto listaProdutosUnico(@PathVariable (value="id") long id){
		return produtoRepository.findById(id);
	}
	
	@ApiOperation(value="Salva um Produto")
	@PostMapping("/produto")
	public Produto salvaProduto(@RequestBody @Validated Produto produto){
		return produtoRepository.save(produto);
	}	

	@ApiOperation(value="Remove um Produto da lista")
	@DeleteMapping("/produto")
	public void deletaProduto(@RequestBody @Validated Produto produto){
		produtoRepository.delete(produto);
	}	

	@ApiOperation(value="Atualiza um Produto da lista")
	@PutMapping("/produto")
	public Produto atualizaProduto(@RequestBody @Validated Produto produto){
		return produtoRepository.save(produto);
	}
}
