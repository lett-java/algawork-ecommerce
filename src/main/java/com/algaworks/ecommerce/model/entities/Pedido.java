package com.algaworks.ecommerce.model.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.algaworks.ecommerce.enums.StatusPedidoEnum;
import com.algaworks.ecommerce.listener.GenericoListener;
import com.algaworks.ecommerce.listener.GerarNotaFiscalListener;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@EntityListeners({ GerarNotaFiscalListener.class, GenericoListener.class })
@Table(name = "pedido")
public class Pedido {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@Column(name = "data_criacao")
	private LocalDateTime dataCriacao;

	@Column(name = "data_ultima_atualizacao")
	private LocalDateTime dataUltimaAtualizacao;

	@Column(name = "data_conclusao")
	private LocalDateTime dataConclusao;

	@OneToOne(mappedBy = "pedido")
	private NotaFiscal notaFiscal;

	private BigDecimal total;

	@Enumerated(EnumType.STRING)
	private StatusPedidoEnum status;

	@Embedded
	private EnderecoEntregaPedido enderecoEntrega;

	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itens;

	@OneToOne(mappedBy = "pedido")
	private PagamentoCartao pagamento;

	public void calcularTotal() {
		if (this.itens != null) {
			this.total = this.itens.stream().map(ItemPedido::getPrecoProduto).reduce(BigDecimal.ZERO, BigDecimal::add);
		}
	}

	@PrePersist
	public void aoPersistir() {
		this.dataCriacao = LocalDateTime.now();
		calcularTotal();
	}

	@PreUpdate
	public void aoAtualizar() {
		this.dataUltimaAtualizacao = LocalDateTime.now();
		calcularTotal();
	}

	@PostPersist
	public void aposPersistir() {
		System.out.println("Após persistir Pedido");
	}

	@PostUpdate
	public void aposAtualizar() {
		System.out.println("Após atualizar Pedido");
	}

	@PostRemove
	public void aposRemover() {
		System.out.println("Após remover Pedido");
	}

	public boolean isPago() {
		return StatusPedidoEnum.PAGO.equals(this.status);
	}

}
