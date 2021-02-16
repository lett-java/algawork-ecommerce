package com.algaworks.ecommerce.model.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.algaworks.ecommerce.enums.StatusPagamentoEnum;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "pagamento_cartao")
public class PagamentoCartao {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@MapsId("pedidoId")
	@OneToOne(optional = false)
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;

	@Enumerated(EnumType.STRING)
	private StatusPagamentoEnum status;

	private String numero;
}
