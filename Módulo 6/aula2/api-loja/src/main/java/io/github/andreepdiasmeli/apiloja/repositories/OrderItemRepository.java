package io.github.andreepdiasmeli.apiloja.repositories;

import io.github.andreepdiasmeli.apiloja.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
