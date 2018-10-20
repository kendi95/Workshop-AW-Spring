package com.kohatsu.workshop_aw.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Venda implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(pattern="dd/MM/YYYY HH:mm", timezone="America/Brazil")
	private LocalDateTime cadastro;
	
	@JsonIgnoreProperties("venda")
	@Valid
	@NotEmpty
	@OneToMany(mappedBy="venda", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Item> items = new ArrayList<>();
	
	@ManyToOne
	private Cliente cliente;
	
	@NotNull
	private BigDecimal frete;
	
	private BigDecimal total;
	
	
	public Venda() {}


	public Venda(Long id, LocalDateTime cadastro, @Valid @NotEmpty List<Item> items, Cliente cliente,
			@NotNull BigDecimal frete, BigDecimal total) {
		this.id = id;
		this.cadastro = cadastro;
		this.items = items;
		this.cliente = cliente;
		this.frete = frete;
		this.total = total;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public LocalDateTime getCadastro() {
		return cadastro;
	}


	public void setCadastro(LocalDateTime cadastro) {
		this.cadastro = cadastro;
	}


	public List<Item> getItems() {
		return items;
	}


	public void setItems(List<Item> items) {
		this.items = items;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public BigDecimal getFrete() {
		return frete;
	}


	public void setFrete(BigDecimal frete) {
		this.frete = frete;
	}


	public BigDecimal getTotal() {
		return total;
	}


	public void setTotal(BigDecimal total) {
		this.total = total;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
