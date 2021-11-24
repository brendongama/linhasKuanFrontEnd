package com.linhaskuan.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linhaskuan.domain.Pedido;
import com.linhaskuan.domain.dtos.PedidoDto;
import com.linhaskuan.repository.PedidosRepository;
import com.linhaskuan.services.exceptions.ObjectnotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidosRepository pedidosRepository;

	public Pedido create(PedidoDto pedidoDTO) {
		Pedido novoPedido = new Pedido(pedidoDTO);
		return pedidosRepository.save(novoPedido);
	}

	public List<Pedido> findAll() {
		return pedidosRepository.findAll();
	}

	public void delete(Long id) {
		pedidosRepository.deleteById(id);
	}

	public Pedido findById(Long id) {
		Optional<Pedido> obj = pedidosRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Pedido não encontrado! Id: " + id));
	}

	public Pedido update(Long id, PedidoDto pedidoDto) {
		pedidoDto.setId(id);
		Pedido oldPedido = findById(id);

		oldPedido = new Pedido(pedidoDto);
		return pedidosRepository.save(oldPedido);
	}

}
