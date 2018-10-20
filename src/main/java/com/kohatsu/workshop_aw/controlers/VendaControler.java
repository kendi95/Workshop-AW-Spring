package com.kohatsu.workshop_aw.controlers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kohatsu.workshop_aw.entities.Venda;
import com.kohatsu.workshop_aw.services.VendaService;

@CrossOrigin("*")
@RestController
@RequestMapping("api/vendas")
public class VendaControler {

	@Autowired
	private VendaService vendaService;
	
	@GetMapping
	public List<Venda> findAll(){
		return vendaService.findAll();
	}
	
	@PostMapping
	public Venda adicionar(@RequestBody @Valid Venda obj) {
		return vendaService.insert(obj);
	}
	
}
