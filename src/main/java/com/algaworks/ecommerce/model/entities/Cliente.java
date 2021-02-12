package com.algaworks.ecommerce.model.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.algaworks.ecommerce.enums.SexoEnum;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "cliente")
public class Cliente {

	@Id
	@EqualsAndHashCode.Include
	private Integer id;

	private String nome;
	
	@Enumerated(EnumType.STRING)
	private SexoEnum sexo;

}
