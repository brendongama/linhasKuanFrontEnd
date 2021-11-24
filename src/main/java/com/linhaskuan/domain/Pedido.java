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

	private String status;
	private String descricao;
	private String endereco;
	private String cep;
	private String cidade;
	private String rg;
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

	public Pedido(PedidoDto pedidoDto) {
		super();
		this.id = pedidoDto.getId();
		this.nomeCliente = pedidoDto.getNomeCliente();
		this.dataPedido = pedidoDto.getDataPedido();
		this.status = pedidoDto.getStatus();
		this.descricao = pedidoDto.getDescricao();
		this.endereco = pedidoDto.getEndereco();
		this.cep = pedidoDto.getCep();
		this.cidade = pedidoDto.getCidade();
		this.rg = pedidoDto.getRg();
		this.celular = pedidoDto.getCelular();
		this.valor = pedidoDto.getValor();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		return true;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", nomeCliente=" + nomeCliente + ", dataPedido=" + dataPedido + ", status=" + status
				+ ", descricao=" + descricao + ", endereco=" + endereco + ", cep=" + cep + ", cidade=" + cidade
				+ ", rg=" + rg + ", celular=" + celular + ", Valor=" + valor + "]";
	}

}
