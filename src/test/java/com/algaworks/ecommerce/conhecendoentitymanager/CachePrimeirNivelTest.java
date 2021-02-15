package com.algaworks.ecommerce.conhecendoentitymanager;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.entities.Produto;

public class CachePrimeirNivelTest extends EntityManagerTest {

	@Test
	public void verificaCache() {
		Produto produto = entityManager.find(Produto.class, 1);
		System.out.println(produto.getNome());

		System.out.println("--------------------------------------");

		Produto produtoResgatado = entityManager.find(Produto.class, produto.getId());
		System.out.println(produtoResgatado.getNome());

	}

	@Test
	public void verificaLimpandoCache() {
		Produto produto = entityManager.find(Produto.class, 1);
		System.out.println(produto.getNome());
		entityManager.clear();
		System.out.println("--------------------Limpando Cache------------------");

		Produto produtoResgatado = entityManager.find(Produto.class, produto.getId());
		System.out.println(produtoResgatado.getNome());

	}

}
