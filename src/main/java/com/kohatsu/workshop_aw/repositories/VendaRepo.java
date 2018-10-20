package com.kohatsu.workshop_aw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kohatsu.workshop_aw.entities.Venda;

@Repository
public interface VendaRepo extends JpaRepository<Venda, Long>{

}
