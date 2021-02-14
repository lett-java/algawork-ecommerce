package com.algaworks.ecommerce.mapeamentobasico;

import static org.junit.Assert.*;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.enums.SexoEnum;
import com.algaworks.ecommerce.model.entities.Cliente;

public class MapeandoEnumeracoesTest extends EntityManagerTest {

	@Test
	public void deveTestarEnum() {
		Cliente cliente = new Cliente();
		cliente.setNome("José Mineiro");
		cliente.setSexo(SexoEnum.MASCULINO);

		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		entityManager.getTransaction().commit();

		entityManager.clear();

		Cliente clienteVerificado = entityManager.find(Cliente.class, cliente.getId());

		assertEquals(cliente.getId(), clienteVerificado.getId());
		assertEquals(cliente.getNome(), clienteVerificado.getNome());
		assertEquals(cliente.getSexo(), clienteVerificado.getSexo());

	}

}
