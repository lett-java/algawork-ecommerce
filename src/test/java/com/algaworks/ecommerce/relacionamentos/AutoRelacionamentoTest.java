package com.algaworks.ecommerce.relacionamentos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.entities.Categoria;

public class AutoRelacionamentoTest extends EntityManagerTest {

	@Test
	public void deveVerificarRelacionamento() {
		Categoria categoriaPai = new Categoria();
		categoriaPai.setNome("Eletronicos");
		
		Categoria categoria = new Categoria();
		categoria.setNome("Celulares");
		categoria.setCategoriaPai(categoriaPai);
		
		entityManager.getTransaction().begin();
		entityManager.persist(categoriaPai);
		entityManager.persist(categoria);
		entityManager.getTransaction().commit();

		entityManager.clear();

		assertNotNull(entityManager.find(Categoria.class, categoria.getId()).getCategoriaPai());
		assertFalse(entityManager.find(Categoria.class, categoriaPai.getId()).getCategorias().isEmpty());

	}

}
