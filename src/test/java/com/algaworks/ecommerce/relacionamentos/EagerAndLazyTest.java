package com.algaworks.ecommerce.relacionamentos;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.entities.Pedido;

public class EagerAndLazyTest extends EntityManagerTest {
	
	@Test
	public void deveVertificarComportamento() {
		Pedido pedido = entityManager.find(Pedido.class, 1);
		
		pedido.getItens().isEmpty();
	}

}
