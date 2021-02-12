package com.algaworks.ecommerce.model.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "produto")
public class Produto {

	@Id
	@EqualsAndHashCode.Include
	private Integer id;

	private String nome;

	private String descricao;

	private BigDecimal preco;
}