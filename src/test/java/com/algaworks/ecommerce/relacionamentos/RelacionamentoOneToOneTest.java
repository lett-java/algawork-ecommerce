package com.algaworks.ecommerce.relacionamentos;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.enums.StatusPagamentoEnum;
import com.algaworks.ecommerce.model.entities.NotaFiscal;
import com.algaworks.ecommerce.model.entities.PagamentoCartao;
import com.algaworks.ecommerce.model.entities.Pedido;

public class RelacionamentoOneToOneTest extends EntityManagerTest {

	@Test
	public void deveVerificarRelacionamento() {
		Pedido pedido = entityManager.find(Pedido.class, 1);

		PagamentoCartao pagamentoCartao = new PagamentoCartao();
		pagamentoCartao.setNumero("1234");
		pagamentoCartao.setStatus(StatusPagamentoEnum.PROCESSANDO);
		pagamentoCartao.setPedido(pedido);

		persistirEntidade(pagamentoCartao);

		assertNotNull(entityManager.find(Pedido.class, pedido.getId()).getPagamento());
	}

	@Test
	public void deveVerificarRelacionamentoPedidoNotaFiscal() {
		Pedido pedido = entityManager.find(Pedido.class, 1);

		NotaFiscal notaFiscal = new NotaFiscal();
		notaFiscal.setXml(carregarNotaFiscal());
		notaFiscal.setDataEmissao(new Date());
		notaFiscal.setPedido(pedido);

		persistirEntidade(notaFiscal);

		assertNotNull(entityManager.find(Pedido.class, pedido.getId()).getNotaFiscal());
	}
}
