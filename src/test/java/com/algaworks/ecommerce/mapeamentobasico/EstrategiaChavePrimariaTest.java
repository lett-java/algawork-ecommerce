package com.algaworks.ecommerce.mapeamentobasico;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.entities.Categoria;

public class EstrategiaChavePrimariaTest extends EntityManagerTest {

	@Test
	public void deveTestarEstrategiaIdentity() {
		Categoria categoria = new Categoria();
		categoria.setNome("Eletrônicos");

		entityManager.getTransaction().begin();
		entityManager.persist(categoria);
		entityManager.getTransaction().commit();

		entityManager.clear();

		Categoria categoriaVerificada = entityManager.find(Categoria.class, categoria.getId());
		assertNotNull(categoriaVerificada);

	}

}
