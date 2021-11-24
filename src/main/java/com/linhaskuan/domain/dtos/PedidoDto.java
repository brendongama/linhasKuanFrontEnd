package com.linhaskuan.domain.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.linhaskuan.domain.Pedido;

public class PedidoDto implements Serializable {
	private static final long serialVersionUID = 1L;

	protected long id;
	protected String nomeCliente;

	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataPedido = LocalDate.now();

	protected String descricao;
	protected String endereco;
	protected String celular;
	protected BigDecimal valor;

	public PedidoDto() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public PedidoDto(Pedido pedido) {
		super();
		this.id = pedido.getId();
		this.nomeCliente = pedido.getNomeCliente();
		this.dataPedido = pedido.getDataPedido();
		this.descricao = pedido.getDescricao();
		this.endereco = pedido.getEndereco();
		this.celular = pedido.getCelular();
		this.valor = pedido.getValor();
	}

}
