package com.algaworks.ecommerce.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
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
	private Integer id;

	@Column(name = "pedido_id")
	private Integer pedidoId;

	@Enumerated(EnumType.STRING)
	private StatusPagamentoEnum status;

	private String numero;
}
