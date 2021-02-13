package com.algaworks.ecommerce.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.algaworks.ecommerce.enums.StatusPagamentoEnum;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "pagamento_boleto")
public class PagamentoBoleto {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "pedido_id")
	private Integer pedidoId;

	@Enumerated(EnumType.STRING)
	private StatusPagamentoEnum status;

	@Column(name = "codigo_barras")
	private String codigoBarras;
}
