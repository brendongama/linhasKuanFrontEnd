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

	protected String status;
	protected String descricao;
	protected String endereco;
	protected String cep;
	protected String cidade;
	protected String rg;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
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
		this.status = pedido.getStatus();
		this.descricao = pedido.getDescricao();
		this.endereco = pedido.getEndereco();
		this.cep = pedido.getCep();
		this.cidade = pedido.getCidade();
		this.rg = pedido.getRg();
		this.celular = pedido.getCelular();
		this.valor = pedido.getValor();
	}

}
