package com.algaworks.ecommerce.iniciandocomjpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;

public class ConsultadoRegistrosTest extends EntityManagerTest {

	@Test
	public void deveBuscarPorIdentificador() {
		Produto produto = entityManager.find(Produto.class, 1);
//		Produto produto = entityManager.getReference(Produto.class, 1);

		assertNotNull(produto);
		assertEquals("Kindle", produto.getNome());
	}

	@Test
	public void deveAtualizarReferencia() {
		Produto produto = entityManager.find(Produto.class, 1);
		produto.setNome("Microfone");

		entityManager.refresh(produto);

		assertEquals("Kindle", produto.getNome());
	}

}
