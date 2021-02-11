package com.algaworks.ecommerce.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Produto {

	@Id
	@EqualsAndHashCode.Include
	private Integer id;

	private String nome;

	private String descricao;

	private BigDecimal preco;
}
