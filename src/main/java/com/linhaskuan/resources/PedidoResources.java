package com.linhaskuan.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.linhaskuan.domain.Pedido;
import com.linhaskuan.domain.dtos.PedidoDto;
import com.linhaskuan.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResources {

	@Autowired
	private PedidoService pedidoService;

	@PostMapping
	public ResponseEntity<PedidoDto> create(@RequestBody PedidoDto pedidoDto) {
		Pedido novoPedido = pedidoService.create(pedidoDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novoPedido.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@GetMapping
	public ResponseEntity<List<PedidoDto>> findAll() {
		List<Pedido> list = pedidoService.findAll();
		List<PedidoDto> listDTO = list.stream().map(obj -> new PedidoDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PedidoDto> findById(@PathVariable Long id) {
		Pedido pedido = pedidoService.findById(id);
		return ResponseEntity.ok().body(new PedidoDto(pedido));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<PedidoDto> update(@PathVariable Long id, @RequestBody PedidoDto pedidoDto) {
		Pedido pedido = pedidoService.update(id, pedidoDto);
		return ResponseEntity.ok().body(new PedidoDto(pedido));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<PedidoDto> delete(@PathVariable Long id) {
		pedidoService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
