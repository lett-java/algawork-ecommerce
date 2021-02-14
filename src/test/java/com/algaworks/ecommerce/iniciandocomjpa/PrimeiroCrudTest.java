package com.algaworks.ecommerce.iniciandocomjpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.entities.Cliente;

public class PrimeiroCrudTest extends EntityManagerTest {

	@Test
	public void deveInserirRegistro() {
		Cliente cliente = new Cliente();

		cliente.setNome("João Lucas");

		persistirEntidade(cliente);
		assertEquals(cliente, entityManager.find(Cliente.class, cliente.getId()));
	}

	@Test
	public void deveConsultarRegistro() {
		Cliente cliente = entityManager.find(Cliente.class, 2);

		assertNotNull(cliente);
		assertEquals("Marcos Mariano", cliente.getNome());
	}

	@Test
	public void deveAtualizarRegistro() {
		Cliente cliente = entityManager.find(Cliente.class, 3);

		entityManager.getTransaction().begin();
		cliente.setNome("Roberto Andrade");
		entityManager.persist(cliente);
		entityManager.getTransaction().commit();

		entityManager.clear();
		assertNotNull(cliente);
		assertEquals("Roberto Andrade", cliente.getNome());
	}

	@Test
	public void deveRemoverRegistro() {
		Cliente cliente = new Cliente();

		cliente.setNome("Fabio Lettieri");

		persistirEntidade(cliente);
		assertNotNull(entityManager.find(Cliente.class, cliente.getId()));

		removerEntidade(entityManager.find(Cliente.class, cliente.getId()));
		assertNull(entityManager.find(Cliente.class, cliente.getId()));
	}

}
