package com.algaworks.ecommerce.conhecendoentitymanager;

import java.math.BigDecimal;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.entities.Produto;

public class ContextoDePersistenciaTest extends EntityManagerTest {

	@Test
	public void usarContextoPersistencia() {
		entityManager.getTransaction().begin();
		Produto produto = entityManager.find(Produto.class, 1);
		produto.setPreco(new BigDecimal(100.0));
		
		Produto produto2 = new Produto();
		produto2.setNome("Caneca para caf�");
		produto2.setPreco(new BigDecimal(10.0));
		produto2.setDescricao("Boa caneca para caf�");
		
		entityManager.persist(produto2);
		
		Produto produto3 = new Produto();
		produto3.setNome("Caneca para ch�");
		produto3.setPreco(new BigDecimal(10.0));
		produto3.setDescricao("Boa caneca para ch�");
		
		entityManager.merge(produto3);
		
		produto3.setDescricao("Alterar descri��o");
		
		entityManager.getTransaction().commit();

	}

}
