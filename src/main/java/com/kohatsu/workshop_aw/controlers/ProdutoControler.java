package com.kohatsu.workshop_aw.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kohatsu.workshop_aw.entities.Produto;
import com.kohatsu.workshop_aw.services.ProdutoService;

@CrossOrigin("*")
@RestController
@RequestMapping("api/produtos")
public class ProdutoControler {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public List<Produto> findAll(){
		return produtoService.findAll();
	}
	
}
