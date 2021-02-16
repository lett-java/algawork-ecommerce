package com.algaworks.ecommerce.model.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DiscriminatorValue("boleto")
@Entity
public class PagamentoBoleto extends Pagamento {

	@Column(name = "codigo_barras")
	private String codigoBarras;
}
