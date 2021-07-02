package io.github.andreepdiasmeli.apirestaurante.service;

import io.github.andreepdiasmeli.apirestaurante.entity.Order;
import io.github.andreepdiasmeli.apirestaurante.entity.OrderItem;
import io.github.andreepdiasmeli.apirestaurante.entity.Table;
import io.github.andreepdiasmeli.apirestaurante.repository.OrderItemRepository;
import io.github.andreepdiasmeli.apirestaurante.repository.OrderRepository;
import io.github.andreepdiasmeli.apirestaurante.repository.TableRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final TableRepository tableRepository;

    public DBService(OrderRepository orderRepository, OrderItemRepository orderItemRepository, TableRepository tableRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.tableRepository = tableRepository;
    }

    public void instantiateDB() {
        Table t1 = new Table();
        Table t2 = new Table();

        Order o1 = new Order(t1);
        Order o2 = new Order(t1);
        Order o3 = new Order(t2);

        t1.addOrder(o1);
        t1.addOrder(o2);
        t2.addOrder(o3);

        OrderItem oi1 = new OrderItem("Batata Frita", "4.99", 2, o1);
        OrderItem oi2 = new OrderItem("Coca-Cola", "2.99", 2, o1);

        OrderItem oi3 = new OrderItem("Pizza de chocolate branco", "24.99", 1, o2);
        OrderItem oi4 = new OrderItem("Pepsi", "2.49", 1, o2);

        OrderItem oi5 = new OrderItem("Salada de Frutas", "9.99", 2, o3);
        OrderItem oi6 = new OrderItem("Suco de Uva", "7.99", 1, o3);

        o1.addOrderItem(oi1);
        o1.addOrderItem(oi2);
        o2.addOrderItem(oi3);
        o2.addOrderItem(oi4);
        o3.addOrderItem(oi5);
        o3.addOrderItem(oi6);

        tableRepository.saveAll(List.of(t1, t2));
    }
}
