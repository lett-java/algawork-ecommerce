package com.algaworks.ecommerce.relacionamentos;

import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.entities.Pedido;

public class RemovendoEntidadesReferenciadasTest extends EntityManagerTest {

	@Test
	public void deveRemoverEntidadeRelacionada() {
		Pedido pedido = entityManager.find(Pedido.class, 1);

		entityManager.getTransaction().begin();
		pedido.getItens().forEach(item -> entityManager.remove(item));
		entityManager.remove(pedido);
		entityManager.getTransaction().commit();

		entityManager.clear();

		assertNull(entityManager.find(Pedido.class, 1));

	}

}
