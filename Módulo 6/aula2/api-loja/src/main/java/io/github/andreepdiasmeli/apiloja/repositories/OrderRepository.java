package io.github.andreepdiasmeli.apiloja.repositories;

import io.github.andreepdiasmeli.apiloja.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
