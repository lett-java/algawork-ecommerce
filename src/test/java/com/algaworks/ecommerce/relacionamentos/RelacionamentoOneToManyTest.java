package com.algaworks.ecommerce.relacionamentos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.enums.StatusPedidoEnum;
import com.algaworks.ecommerce.model.entities.Cliente;
import com.algaworks.ecommerce.model.entities.ItemPedido;
import com.algaworks.ecommerce.model.entities.ItemPedidoId;
import com.algaworks.ecommerce.model.entities.Pedido;
import com.algaworks.ecommerce.model.entities.Produto;

public class RelacionamentoOneToManyTest extends EntityManagerTest {

	@Test
	public void deveVerificarRelacionamentoPedidoComCliente() {
		Cliente cliente = entityManager.find(Cliente.class, 1);

		Pedido pedido = new Pedido();

		pedido.setStatus(StatusPedidoEnum.AGUARDANDO);
		pedido.setDataCriacao(LocalDateTime.now());
		pedido.setTotal(BigDecimal.TEN);
		pedido.setCliente(cliente);

		persistirEntidade(pedido);
		Cliente clienteVerificado = entityManager.find(Cliente.class, cliente.getId());

		assertNotNull(clienteVerificado);
		assertFalse(clienteVerificado.getPedidos().isEmpty());
	}

	@Test
	public void deveVerificarRelacionamentoPedido() {
		Cliente cliente = entityManager.find(Cliente.class, 1);
		Produto produto = entityManager.find(Produto.class, 1);

		Pedido pedido = new Pedido();
		pedido.setStatus(StatusPedidoEnum.AGUARDANDO);
		pedido.setDataCriacao(LocalDateTime.now());
		pedido.setTotal(BigDecimal.TEN);
		pedido.setCliente(cliente);


		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setId(new ItemPedidoId());
		itemPedido.setPedido(pedido);
		itemPedido.setProduto(produto);
		itemPedido.setPrecoProduto(produto.getPreco());
		itemPedido.setQuantidade(1);

		persistirEntidades(pedido, itemPedido);
		
		Pedido pedidoVerificado = entityManager.find(Pedido.class, pedido.getId());

		assertNotNull(pedidoVerificado);
		assertFalse(pedidoVerificado.getItens().isEmpty());
	}

}
