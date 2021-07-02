package io.github.andreepdiasmeli.apirestaurante.repository;

import io.github.andreepdiasmeli.apirestaurante.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
