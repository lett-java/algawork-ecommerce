package com.algaworks.ecommerce.mapeamentoavancado;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.entities.Atributo;
import com.algaworks.ecommerce.model.entities.Cliente;
import com.algaworks.ecommerce.model.entities.Produto;

public class ElementCollectionTest extends EntityManagerTest {

	@Test
	public void deveAplicarTags() {
		Produto produto = entityManager.find(Produto.class, 1);
		produto.setTags(Arrays.asList("e-book", "livro-digital"));

		persistirEntidade(produto);

		assertFalse(entityManager.find(Produto.class, produto.getId()).getTags().isEmpty());
	}

	@Test
	public void deveAplicarAtributos() {
		Produto produto = entityManager.find(Produto.class, 1);
		produto.setAtributos(Arrays.asList(new Atributo("tela", "320x600")));

		persistirEntidade(produto);

		assertFalse(entityManager.find(Produto.class, produto.getId()).getAtributos().isEmpty());
	}

	@Test
	public void deveAplicarContato() {
		Cliente cliente = entityManager.find(Cliente.class, 1);
		cliente.setContatos(Collections.singletonMap("e-mail", "fernando@email.com"));
		
		persistirEntidade(cliente);
		
		assertEquals("fernando@email.com", entityManager.find(Cliente.class, cliente.getId()).getContatos().get("e-mail"));
	}
}
