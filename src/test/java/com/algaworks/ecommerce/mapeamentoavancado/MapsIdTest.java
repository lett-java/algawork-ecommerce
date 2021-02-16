package com.algaworks.ecommerce.mapeamentoavancado;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.util.Date;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.enums.StatusPedidoEnum;
import com.algaworks.ecommerce.model.entities.Cliente;
import com.algaworks.ecommerce.model.entities.ItemPedido;
import com.algaworks.ecommerce.model.entities.ItemPedidoId;
import com.algaworks.ecommerce.model.entities.NotaFiscal;
import com.algaworks.ecommerce.model.entities.Pedido;
import com.algaworks.ecommerce.model.entities.Produto;

public class MapsIdTest extends EntityManagerTest {

	@Test
	public void deveInserirPagamento() {
		Pedido pedido = entityManager.find(Pedido.class, 1);

		NotaFiscal notaFiscal = new NotaFiscal();
		notaFiscal.setPedido(pedido);
		notaFiscal.setDataEmissao(new Date());
		notaFiscal.setXml("<xml/>");

		persistirEntidade(notaFiscal);

		NotaFiscal notaFiscalVerificado = entityManager.find(NotaFiscal.class, notaFiscal.getId());
		assertNotNull(notaFiscalVerificado);
		assertEquals(pedido.getId(), notaFiscalVerificado.getId());
	}

	@Test
	public void deveInserirItemPedido() {
		Cliente cliente = entityManager.find(Cliente.class, 1);
		Produto produto = entityManager.find(Produto.class, 1);

		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setDataCriacao(LocalDateTime.now());
		pedido.setStatus(StatusPedidoEnum.AGUARDANDO);
		pedido.setTotal(produto.getPreco());

		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setId(new ItemPedidoId());
		itemPedido.setPedido(pedido);
		itemPedido.setProduto(produto);
		itemPedido.setPrecoProduto(produto.getPreco());
		itemPedido.setQuantidade(1);

		persistirEntidades(pedido, itemPedido);

		assertNotNull(entityManager.find(ItemPedido.class, new ItemPedidoId(pedido.getId(), produto.getId())));
	}
}
