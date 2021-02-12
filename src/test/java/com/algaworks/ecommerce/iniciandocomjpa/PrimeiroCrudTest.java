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

		cliente.setId(4);
		cliente.setNome("João Lucas");

		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		entityManager.getTransaction().commit();

		entityManager.clear();
		assertEquals(cliente, entityManager.find(Cliente.class, 4));
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
		Cliente cliente = entityManager.find(Cliente.class, 1);

		entityManager.getTransaction().begin();
		entityManager.remove(cliente);
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		cliente = entityManager.find(Cliente.class, 1);
		assertNull(cliente);
	}

}
