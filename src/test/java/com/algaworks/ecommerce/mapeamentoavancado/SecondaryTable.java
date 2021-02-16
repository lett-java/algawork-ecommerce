package com.algaworks.ecommerce.mapeamentoavancado;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.Test;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.enums.SexoEnum;
import com.algaworks.ecommerce.model.entities.Cliente;

public class SecondaryTable extends EntityManagerTest {

	@Test
	public void deveSalvarCliente() {
		Cliente cliente = new Cliente();
		cliente.setNome("Carlos Finotti");
		cliente.setSexo(SexoEnum.MASCULINO);
		cliente.setDataNascimento(LocalDate.of(1990, 1, 1));

		persistirEntidade(cliente);

		Cliente clienteVerificado = entityManager.find(Cliente.class, cliente.getId());
		assertNotNull(clienteVerificado.getSexo());
		assertNotNull(clienteVerificado.getDataNascimento());

	}

}
