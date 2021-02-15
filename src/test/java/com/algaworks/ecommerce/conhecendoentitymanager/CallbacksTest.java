package com.algaworks.ecommerce.conhecendoentitymanager;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.enums.StatusPedidoEnum;
import com.algaworks.ecommerce.model.entities.Cliente;
import com.algaworks.ecommerce.model.entities.Pedido;

public class CallbacksTest extends EntityManagerTest {
	
	@Test
	public void acionarCallbacks() {
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
