package com.algaworks.ecommerce.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "pagamento_boleto")
public class PagamentoBoleto extends Pagamento {

	@Column(name = "codigo_barras")
	private String codigoBarras;
}
