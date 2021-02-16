package com.algaworks.ecommerce.mapeamentoavancado;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.entities.Cliente;

public class PropriedadesTransientesTest extends EntityManagerTest {

	@Test
	public void deveValidarPrimeiroNome() {
		Cliente cliente = entityManager.find(Cliente.class, 1);

		assertEquals("Fernando", cliente.getPrimeiroNome());

	}

}
