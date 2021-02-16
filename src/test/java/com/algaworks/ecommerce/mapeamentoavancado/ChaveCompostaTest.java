package com.algaworks.ecommerce.mapeamentoavancado;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.enums.StatusPedidoEnum;
import com.algaworks.ecommerce.model.entities.Cliente;
import com.algaworks.ecommerce.model.entities.ItemPedido;
import com.algaworks.ecommerce.model.entities.ItemPedidoId;
import com.algaworks.ecommerce.model.entities.Pedido;
import com.algaworks.ecommerce.model.entities.Produto;

public class ChaveCompostaTest extends EntityManagerTest {

	@Test
	public void deveSalvarItem() {
		Cliente cliente = entityManager.find(Cliente.class, 1);
		Produto produto = entityManager.find(Produto.class, 1);
		
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setDataConclusao(LocalDateTime.now());
		pedido.setStatus(StatusPedidoEnum.AGUARDANDO);
		pedido.setTotal(produto.getPreco());


		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setId(new ItemPedidoId(pedido.getId(), produto.getId()));
		itemPedido.setPedido(pedido);
		itemPedido.setProduto(produto);
		itemPedido.setPrecoProduto(produto.getPreco());
		itemPedido.setQuantidade(1);

		persistirEntidades(pedido, itemPedido);

		Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
		assertNotNull(pedidoVerificacao);
		assertFalse(pedidoVerificacao.getItens().isEmpty());

	}
	
	@Test
	public void buscarItem() {
		ItemPedido itemPedido = entityManager.find(ItemPedido.class, new ItemPedidoId(1, 1));
		
		assertNotNull(itemPedido);
		
	}
	
	
	

}
