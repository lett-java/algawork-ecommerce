package com.algaworks.ecommerce.mapeamentoavancado;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.enums.StatusPagamentoEnum;
import com.algaworks.ecommerce.model.entities.Cliente;
import com.algaworks.ecommerce.model.entities.Pagamento;
import com.algaworks.ecommerce.model.entities.PagamentoCartao;
import com.algaworks.ecommerce.model.entities.Pedido;

public class HerancaTest extends EntityManagerTest {

	@Test
	public void deveSalvarCliente() {
		Cliente cliente = new Cliente();
		cliente.setNome("Fernanda Morais");

		persistirEntidade(cliente);

		assertNotNull(entityManager.find(Cliente.class, cliente.getId()));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void deveBuscarPagamentos() {
		List<Pagamento> pagamentos = entityManager.createQuery("select p from Pagamento p").getResultList();

		assertFalse(pagamentos.isEmpty());
	}

	@Test
	public void deveIncluirPagamentoPedido() {
		Pedido pedido = entityManager.find(Pedido.class, 1);

		PagamentoCartao pagamentoCartao = new PagamentoCartao();
		pagamentoCartao.setPedido(pedido);
		pagamentoCartao.setStatus(StatusPagamentoEnum.PROCESSANDO);
		pagamentoCartao.setNumeroCartao("123");

		persistirEntidade(pagamentoCartao);

		assertNotNull(entityManager.find(Pedido.class, pedido.getId()).getPagamento());
	}

}
