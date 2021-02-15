package com.algaworks.ecommerce.conhecendoentitymanager;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.enums.StatusPedidoEnum;
import com.algaworks.ecommerce.model.entities.Pedido;

public class GerenciamentoTransacoesTest extends EntityManagerTest {

	@Test(expected = Exception.class)
	public void abrirFecharCancelarTransacao() {
		try {
			entityManager.getTransaction().begin();
			metodoDeNegocio();
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw e;
		}
	}

	public void metodoDeNegocio() {
		Pedido pedido = entityManager.find(Pedido.class, 1);
		pedido.setStatus(StatusPedidoEnum.PAGO);

		if (pedido.getPagamento() == null) {
			throw new RuntimeException("Pedido ainda não foi pago");
		}
	}

}
