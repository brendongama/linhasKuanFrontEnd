package com.linhaskuan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.linhaskuan.domain.Pedido;

public interface PedidosRepository extends JpaRepository<Pedido, Long> {

}
