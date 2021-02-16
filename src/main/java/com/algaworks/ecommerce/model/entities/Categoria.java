package com.algaworks.ecommerce.model.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categoria")
@Getter
@Setter
public class Categoria extends EntidadeBaseInteger {

	private String nome;

	@ManyToOne
	@JoinColumn(name = "categoria_pai_id")
	private Categoria categoriaPai;

	@OneToMany(mappedBy = "categoriaPai")
	private List<Categoria> categorias;

	@ManyToMany(mappedBy = "categorias")
	private List<Produto> produtos;

}
