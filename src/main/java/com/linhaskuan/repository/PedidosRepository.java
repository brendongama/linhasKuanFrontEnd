package com.linhaskuan.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.linhaskuan.domain.Pedido;

public interface PedidosRepository extends JpaRepository<Pedido, Long> {

}
