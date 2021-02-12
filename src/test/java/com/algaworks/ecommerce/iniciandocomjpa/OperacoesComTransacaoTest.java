package com.algaworks.ecommerce.iniciandocomjpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.entities.Produto;

public class OperacoesComTransacaoTest extends EntityManagerTest {
	
	@Test
	public void deveImpedirOperacaoComBancoDeDados() {
		Produto produto = entityManager.find(Produto.class, 1);
		entityManager.detach(produto);
		
		entityManager.getTransaction().begin();
		produto.setNome("Kindle Paperwhite 2ª Geração");
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		Produto produtoVerificado = entityManager.find(Produto.class, produto.getId());
		assertEquals("Kindle", produtoVerificado.getNome());
	}
	
	@Test
	public void deveMostrarDiferencaPersistEMerge() {
		Produto produtoPersist = new Produto();
		produtoPersist.setId(5);
		produtoPersist.setNome("Smartphone One Plus");
		produtoPersist.setDescricao("O processador mais rapido.");
		produtoPersist.setPreco(new BigDecimal(2000));
		
		entityManager.getTransaction().begin();
		entityManager.persist(produtoPersist);
		produtoPersist.setNome("SmartPhone Two Plus");
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		Produto produtoVerificacaoPersistence = entityManager.find(Produto.class, produtoPersist.getId());
		assertNotNull(produtoVerificacaoPersistence);
		
		Produto productMerge = new Produto();
		productMerge.setId(6);
		productMerge.setNome("Notebook Dell");
		productMerge.setDescricao("O Melhor da categoria.");
		productMerge.setPreco(new BigDecimal(2000));
		
		entityManager.getTransaction().begin();
		productMerge = entityManager.merge(productMerge);
		productMerge.setNome("Notebook Dell Gamer");
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		Produto produtoVerificacaoMerge = entityManager.find(Produto.class, productMerge.getId());
		assertNotNull(produtoVerificacaoMerge);
		
	}

	@Test
	public void deveInserirObjetoComMerge() {
		Produto produto = new Produto();
		produto.setId(4);
		produto.setNome("Microfone Rode Videmic");
		produto.setDescricao("A melhor qualidade de som.");
		produto.setPreco(new BigDecimal(1000));

		entityManager.getTransaction().begin();
		entityManager.merge(produto);
		entityManager.getTransaction().commit();

		entityManager.clear();

		Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
		assertNotNull(produtoVerificacao);

	}

	@Test
	public void deveAtualizarObjetoGerenciado() {
		Produto produto = entityManager.find(Produto.class, 1);
		
		entityManager.getTransaction().begin();
		produto.setNome("Kindle Paperwhite 2ª Geração");
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		Produto produtoVerificado = entityManager.find(Produto.class, produto.getId());
		assertEquals("Kindle Paperwhite 2ª Geração", produtoVerificado.getNome());
	}
	
	@Test
	public void deveAtualizarObjeto() {
		Produto produto = new Produto();

		produto.setId(1);
		produto.setNome("Kindle Paperwhite");
		produto.setDescricao("Conheça o novo Kindle.");
		produto.setPreco(new BigDecimal(599));

		entityManager.getTransaction().begin();
		entityManager.merge(produto);
		entityManager.getTransaction().commit();

		entityManager.clear();

		Produto produtoVerificado = entityManager.find(Produto.class, produto.getId());
		assertNotNull(produtoVerificado);
		assertEquals("Kindle Paperwhite", produtoVerificado.getNome());
	}

	@Test
	public void deveRemoverObjeto() {
		Produto produto = entityManager.find(Produto.class, 3);

		entityManager.getTransaction().begin();
		entityManager.remove(produto);
		entityManager.getTransaction().commit();

		Produto produtoVerificado = entityManager.find(Produto.class, 3);
		assertNull(produtoVerificado);

	}

	@Test
	public void deveInserirOPrimeiroObjeto() {
		Produto produto = new Produto();
		produto.setId(2);
		produto.setNome("Câmera Canon");
		produto.setDescricao("A melhor definição para suas fotos");
		produto.setPreco(new BigDecimal(5000));

		entityManager.getTransaction().begin();
		entityManager.persist(produto);
		entityManager.getTransaction().commit();

		entityManager.clear();

		Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
		assertNotNull(produtoVerificacao);

	}

	@Test
	public void deveAbrirEFecharATransacao() {
//		Produto produto = new Produto();

		entityManager.getTransaction().begin();

//		entityManager.persist(produto);
//		entityManager.persist(produto);
//		entityManager.remove(produto);

		entityManager.getTransaction().commit();
	}

}
