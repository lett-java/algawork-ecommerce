package com.algaworks.ecommerce.relacionamentos;

import static org.junit.Assert.assertFalse;

import java.util.Arrays;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.entities.Categoria;
import com.algaworks.ecommerce.model.entities.Produto;

public class RelacionamentoManyToManyTest extends EntityManagerTest {

	@Test
	public void deveVerificarRelacionamento() {
		Produto produto = entityManager.find(Produto.class, 1);
		Categoria categoria = entityManager.find(Categoria.class, 1);

		entityManager.getTransaction().begin();
		produto.setCategorias(Arrays.asList(categoria));
		entityManager.getTransaction().commit();

		entityManager.clear();

		Categoria categoriaVerificada = entityManager.find(Categoria.class, categoria.getId());
		assertFalse(categoriaVerificada.getProdutos().isEmpty());

	}
}
