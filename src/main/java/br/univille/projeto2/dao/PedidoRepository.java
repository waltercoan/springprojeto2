package br.univille.projeto2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.univille.projeto2.entity.Pedido;
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}

