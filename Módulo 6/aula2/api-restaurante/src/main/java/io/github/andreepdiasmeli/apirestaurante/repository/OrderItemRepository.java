package io.github.andreepdiasmeli.apirestaurante.repository;

import io.github.andreepdiasmeli.apirestaurante.entity.Order;
import io.github.andreepdiasmeli.apirestaurante.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
