package com.kohatsu.workshop_aw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kohatsu.workshop_aw.entities.Cliente;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Long>{

}
