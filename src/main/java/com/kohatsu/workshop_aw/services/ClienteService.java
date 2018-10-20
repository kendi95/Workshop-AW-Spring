package com.kohatsu.workshop_aw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kohatsu.workshop_aw.entities.Cliente;
import com.kohatsu.workshop_aw.repositories.ClienteRepo;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepo repo;
	
	public List<Cliente> findAll(){
		return repo.findAll();
	}
	
}
