package com.algaworks.ecommerce.model.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.algaworks.ecommerce.enums.StatusPagamentoEnum;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "pagamento")
public abstract class Pagamento extends EntidadeBaseInteger {

	@MapsId
	@OneToOne(optional = false)
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;

	@Enumerated(EnumType.STRING)
	private StatusPagamentoEnum status;

}
