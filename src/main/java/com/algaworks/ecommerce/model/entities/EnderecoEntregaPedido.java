package com.algaworks.ecommerce.model.entities;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class EnderecoEntregaPedido {
	
	private String cep;
	
	private String logradouro;
	
	private String numero;
	
	private String complemento;
	
	private String bairro;
	
	private String cidade;
	
	private String estado;

}