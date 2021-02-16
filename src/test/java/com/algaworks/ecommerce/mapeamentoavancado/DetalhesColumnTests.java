package com.algaworks.ecommerce.mapeamentoavancado;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.entities.Produto;

public class DetalhesColumnTests extends EntityManagerTest {

	@Test
	public void deveImpedirInsercaoDaColunaAtualizacao() {
		Produto produto = new Produto();
		produto.setNome("Teclado para smartphone");
		produto.setDescricao("O mais confortável");
		produto.setPreco(BigDecimal.ONE);
		produto.setDataCriacao(LocalDateTime.now());
		produto.setDataUltimaAtualizacao(LocalDateTime.now());

		persistirEntidade(produto);

		Produto produtoVerificado = entityManager.find(Produto.class, produto.getId());
		assertNotNull(produtoVerificado.getDataCriacao());
		assertNull(produtoVerificado.getDataUltimaAtualizacao());
	}

	@Test
	public void deveImpedirAtualizacaoDaColunaCriacao() {
		Produto produto = entityManager.find(Produto.class, 1);
		produto.setPreco(BigDecimal.TEN);
		produto.setDataCriacao(LocalDateTime.now());
		produto.setDataUltimaAtualizacao(LocalDateTime.now());

		persistirEntidade(produto);

		Produto produtoVerificado = entityManager.find(Produto.class, produto.getId());

		assertNotEquals(produto.getDataCriacao().truncatedTo(ChronoUnit.SECONDS),
				produtoVerificado.getDataCriacao().truncatedTo(ChronoUnit.SECONDS));

		assertEquals(produto.getDataUltimaAtualizacao().truncatedTo(ChronoUnit.SECONDS),
				produtoVerificado.getDataUltimaAtualizacao().truncatedTo(ChronoUnit.SECONDS));

	}
}
