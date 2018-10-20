package com.kohatsu.workshop_aw.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kohatsu.workshop_aw.entities.Venda;
import com.kohatsu.workshop_aw.repositories.ProdutoRepo;
import com.kohatsu.workshop_aw.repositories.VendaRepo;

@Service
public class VendaService {

	@Autowired
	private VendaRepo repo;
	@Autowired
	private ProdutoRepo produtoRepo;
	
	public List<Venda> findAll(){
		return repo.findAll();
	}
	
	public Venda insert(Venda obj) {
		obj.setCadastro(LocalDateTime.now());
		/*obj.getItems().forEach(x ->{
			x.setVenda(obj);
			x.setProduto(produtoRepo.findById(x.getProduto().getId()).get());
		});*/
		
		for(int i = 0; i< obj.getItems().size(); i++) {
			obj.getItems().get(i).setVenda(obj);
			obj.getItems().get(i).setProduto(produtoRepo.findById(obj.getItems().get(i).getProduto().getId()).get());
		}
		
		BigDecimal totalItems = obj.getItems().stream()
				.map(x -> x.getProduto().getValor().multiply(new BigDecimal(x.getQuantidade())))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		
		obj.setTotal(totalItems.add(obj.getFrete()));
		
		return repo.save(obj);
	}
	
}
