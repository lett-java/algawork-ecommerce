package com.algaworks.ecommerce.model.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.algaworks.ecommerce.enums.StatusPedidoEnum;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "pedido")
public class Pedido {

	@Id
	@EqualsAndHashCode.Include
	private Integer id;

	@Column(name = "data_pedido")
	private LocalDateTime dataPedido;

	@Column(name = "data_conclusao")
	private LocalDateTime dataConclusao;

	@Column(name = "nota_fiscal_id")
	private Integer notaFiscalId;

	private BigDecimal total;

	@Enumerated(EnumType.STRING)
	private StatusPedidoEnum status;

}
