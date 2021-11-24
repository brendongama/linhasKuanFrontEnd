package com.linhaskuan.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.linhaskuan.domain.dtos.PedidoDto;

@Entity

public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	private String nomeCliente;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataPedido = LocalDate.now();	
	private String descricao;
	private String endereco;	
	private String cidade;	
	private String celular;
	private BigDecimal valor;

	public Pedido() {
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Pedido(PedidoDto pedidoDto) {
		super();
		this.id = pedidoDto.getId();
		this.nomeCliente = pedidoDto.getNomeCliente();
		this.dataPedido = pedidoDto.getDataPedido();
		this.descricao = pedidoDto.getDescricao();
		this.endereco = pedidoDto.getEndereco();
		this.celular = pedidoDto.getCelular();
		this.valor = pedidoDto.getValor();
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", nomeCliente=" + nomeCliente + ", dataPedido=" + dataPedido + ", descricao=" + descricao + ", endereco=" + endereco + ", cidade=" + cidade
				+ ", celular=" + celular + ", Valor=" + valor + "]";
	}

}
