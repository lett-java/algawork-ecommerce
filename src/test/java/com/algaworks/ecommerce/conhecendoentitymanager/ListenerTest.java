package com.algaworks.ecommerce.conhecendoentitymanager;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.enums.StatusPedidoEnum;
import com.algaworks.ecommerce.model.entities.Cliente;
import com.algaworks.ecommerce.model.entities.Pedido;
import com.algaworks.ecommerce.model.entities.Produto;

public class ListenerTest extends EntityManagerTest {

	@Test
	public void carregarEntidades() {
		Produto produto = entityManager.find(Produto.class, 1);
		Pedido pedido = entityManager.find(Pedido.class, 1);
		
		//remoção de warnings
		produto.getCategorias();
		pedido.getCliente();
	}

	@Test
	public void acionarListener() {
		Cliente cliente = entityManager.find(Cliente.class, 1);

		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setStatus(StatusPedidoEnum.AGUARDANDO);

		entityManager.getTransaction().begin();

		entityManager.persist(pedido);
		entityManager.flush();

		pedido.setStatus(StatusPedidoEnum.PAGO);
		entityManager.getTransaction().commit();

		entityManager.clear();

		assertNotNull(entityManager.find(Pedido.class, pedido.getId()));

	}

}
