package com.algaworks.ecommerce.model.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.algaworks.ecommerce.enums.SexoEnum;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@SecondaryTable(name = "cliente_detalhe", pkJoinColumns = @PrimaryKeyJoinColumn(name = "cliente_id"))
@Table(name = "cliente")
public class Cliente extends EntidadeBaseInteger {

	private String nome;

	@ElementCollection
	@CollectionTable(name = "cliente_contato", joinColumns = @JoinColumn(name = "cliente_id"))
	@MapKeyColumn(name = "tipo")
	@Column(name = "descricao")
	private Map<String, String> contatos;

	@Transient
	private String primeiroNome;

	@Column(table = "cliente_detalhe")
	@Enumerated(EnumType.STRING)
	private SexoEnum sexo;

	@Column(name = "data_nascimento", table = "cliente_detalhe")
	private LocalDate dataNascimento;

	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos;

	@PostLoad
	public void configurarPrimeiroNome() {
		if (nome != null && !nome.isBlank()) {
			int index = nome.indexOf(" ");
			if (index > -1) {
				primeiroNome = nome.substring(0, index);
			}
		}
	}

}
