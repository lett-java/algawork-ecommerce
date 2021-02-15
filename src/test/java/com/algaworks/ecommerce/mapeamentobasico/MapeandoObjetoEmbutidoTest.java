package com.algaworks.ecommerce.mapeamentobasico;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.enums.SexoEnum;
import com.algaworks.ecommerce.enums.StatusPedidoEnum;
import com.algaworks.ecommerce.model.entities.Cliente;
import com.algaworks.ecommerce.model.entities.EnderecoEntregaPedido;
import com.algaworks.ecommerce.model.entities.Pedido;

public class MapeandoObjetoEmbutidoTest extends EntityManagerTest {

	@Test
	public void deveAnalisarMapeamentoObjetoEmbutido() {
		EnderecoEntregaPedido endereco = new EnderecoEntregaPedido();

		endereco.setCep("00000-000");
		endereco.setLogradouro("Rua das Laranjeiras");
		endereco.setNumero("123");
		endereco.setBairro("Centro");
		endereco.setCidade("Uberlândia");
		endereco.setEstado("MG");

		Cliente cliente = new Cliente();
		cliente.setNome("Fabio");
		cliente.setSexo(SexoEnum.MASCULINO);

		Pedido pedido = new Pedido();

		pedido.setDataCriacao(LocalDateTime.now());
		pedido.setStatus(StatusPedidoEnum.AGUARDANDO);
		pedido.setTotal(new BigDecimal(1000));
		pedido.setEnderecoEntrega(endereco);
		pedido.setCliente(cliente);

		persistirEntidades(cliente, pedido);

		Pedido pedidoVerificado = entityManager.find(Pedido.class, pedido.getId());

		assertNotNull(pedidoVerificado);
		assertNotNull(pedidoVerificado.getEnderecoEntrega());
		assertNotNull(pedidoVerificado.getEnderecoEntrega().getCep());
		assertNotNull(pedidoVerificado.getCliente());
		assertEquals(pedidoVerificado.getCliente(), cliente);

	}
}
