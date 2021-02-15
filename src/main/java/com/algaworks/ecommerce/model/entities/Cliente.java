package com.algaworks.ecommerce.model.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.algaworks.ecommerce.enums.SexoEnum;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "cliente")
public class Cliente {
	
	public Cliente() {
		
	}
	
	public Cliente(String nome, SexoEnum sexo) {
		this.nome = nome;
		this.sexo = sexo;
	}

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	@Enumerated(EnumType.STRING)
	private SexoEnum sexo;
	
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos;
	

}
