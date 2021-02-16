package com.algaworks.ecommerce.mapeamentoavancado;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.entities.NotaFiscal;
import com.algaworks.ecommerce.model.entities.Pedido;
import com.algaworks.ecommerce.model.entities.Produto;

public class SalvandoArquivosTest extends EntityManagerTest {

	@Test
	public void deveSalvarXmlNota() {
		Pedido pedido = entityManager.find(Pedido.class, 1);

		NotaFiscal notaFiscal = new NotaFiscal();
		notaFiscal.setPedido(pedido);
		notaFiscal.setDataEmissao(new Date());
		notaFiscal.setXml(carregarNotaFiscal());

		persistirEntidade(notaFiscal);

		NotaFiscal notaFiscalVerificado = entityManager.find(NotaFiscal.class, notaFiscal.getId());
		assertNotNull(notaFiscalVerificado.getXml());
		assertTrue(notaFiscalVerificado.getXml().length > 0);

//		try {
//			OutputStream out = new FileOutputStream(
//					Files.createFile(Paths.get(
//							System.getProperty("user.home") + "/xml.xml")).toFile());
//			out.write(notaFiscalVerificado.getXml());
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
	}

	@Test
	public void deveSalvarFotoProduto() {
		entityManager.getTransaction().begin();
		Produto produto = entityManager.find(Produto.class, 1);
		produto.setFoto(carregarFoto());
		entityManager.getTransaction().commit();

		entityManager.clear();

		Produto produtoVerificado = entityManager.find(Produto.class, 1);
		Assert.assertNotNull(produtoVerificado.getFoto());
		Assert.assertTrue(produtoVerificado.getFoto().length > 0);
	}
}
