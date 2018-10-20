package com.kohatsu.workshop_aw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kohatsu.workshop_aw.entities.Produto;
import com.kohatsu.workshop_aw.repositories.ProdutoRepo;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepo repo;
	
	public List<Produto> findAll(){
		return repo.findAll();
	}
	
}
