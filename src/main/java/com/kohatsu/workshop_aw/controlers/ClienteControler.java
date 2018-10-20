package com.kohatsu.workshop_aw.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kohatsu.workshop_aw.entities.Cliente;
import com.kohatsu.workshop_aw.services.ClienteService;

@CrossOrigin("*")
@RestController
@RequestMapping("api/clientes")
public class ClienteControler {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> findAll(){
		return clienteService.findAll();
	}
	
}
