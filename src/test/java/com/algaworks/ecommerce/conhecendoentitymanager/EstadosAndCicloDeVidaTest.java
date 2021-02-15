package com.algaworks.ecommerce.conhecendoentitymanager;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.entities.Categoria;

public class EstadosAndCicloDeVidaTest extends EntityManagerTest {

	@Test
	public void analisarEstados() {
		Categoria categoriaNovo = new Categoria();

		Categoria categoriaGerenciadaMerge = entityManager.merge(categoriaNovo);
		categoriaGerenciadaMerge.getClass(); //Apenas para parar com a warning 

		Categoria categoriaGerenciada = entityManager.find(Categoria.class, 1);

		entityManager.remove(categoriaGerenciada);
		entityManager.persist(categoriaGerenciada);

		entityManager.detach(categoriaGerenciada);

	}

}
