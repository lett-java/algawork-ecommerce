package com.algaworks.ecommerce.relacionamentos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.enums.StatusPedidoEnum;
import com.algaworks.ecommerce.model.entities.Cliente;
import com.algaworks.ecommerce.model.entities.ItemPedido;
import com.algaworks.ecommerce.model.entities.Pedido;
import com.algaworks.ecommerce.model.entities.Produto;

public class RelacionamentoManyToOneTest extends EntityManagerTest {

	@Test
	public void deveVerificarRelacionamentoPedidoComCliente() {
		Cliente cliente = entityManager.find(Cliente.class, 1);

		Pedido pedido = new Pedido();

		pedido.setStatus(StatusPedidoEnum.AGUARDANDO);
		pedido.setDataPedido(LocalDateTime.now());
		pedido.setTotal(BigDecimal.TEN);

		pedido.setCliente(cliente);

		persistirEntidade(pedido);

		Pedido pedidoVerificado = entityManager.find(Pedido.class, pedido.getId());

		assertNotNull(pedidoVerificado);
		assertNotNull(pedidoVerificado.getCliente());
	}

	@Test
	public void deveVerificarRelacionamentoItemPedidoComProdutoEComPedido() {
		Cliente cliente = entityManager.find(Cliente.class, 1);
		Produto produto = entityManager.find(Produto.class, 1);

		Pedido pedido = new Pedido();
		pedido.setStatus(StatusPedidoEnum.AGUARDANDO);
		pedido.setDataPedido(LocalDateTime.now());
		pedido.setTotal(BigDecimal.TEN);
		pedido.setCliente(cliente);

		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setPedido(pedido);
		itemPedido.setPrecoProduto(produto.getPreco());
		itemPedido.setProduto(produto);
		itemPedido.setQuantidade(1);

		persistirEntidades(pedido, itemPedido);
		ItemPedido itemPedidoVerificado = entityManager.find(ItemPedido.class, itemPedido.getId());

		assertNotNull(itemPedidoVerificado);
		assertEquals(itemPedidoVerificado.getPedido(), pedido);
		assertEquals(itemPedido.getProduto(), produto);

	}

}
