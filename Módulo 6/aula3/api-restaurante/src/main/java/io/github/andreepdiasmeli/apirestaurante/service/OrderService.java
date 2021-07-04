package io.github.andreepdiasmeli.apirestaurante.service;

import io.github.andreepdiasmeli.apirestaurante.dtos.OrderDTO;
import io.github.andreepdiasmeli.apirestaurante.entity.Order;
import io.github.andreepdiasmeli.apirestaurante.entity.OrderItem;
import io.github.andreepdiasmeli.apirestaurante.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    public final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderDTO> findAll() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(OrderDTO::toDTO).collect(Collectors.toList());
    }

    public OrderDTO findById(Long id) {
        Order order = orderRepository.findById(id);
        return OrderDTO.toDTO(order);
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    public OrderDTO create(OrderDTO orderDTO) {
        Order order = orderDTO.toEntity();

        List<OrderItem> orderItems = orderDTO.getOrderItems().stream().map(oi -> oi.toEntity(order)).collect(Collectors.toList());
        order.setOrderItems(orderItems);

        Order newOrder = orderRepository.create(order);

        return OrderDTO.toDTO(newOrder);
    }

    public OrderDTO update(OrderDTO orderDTO) {
        Long orderId = orderDTO.getOrderId();

        Order order = orderRepository.findById(orderId);

        List<OrderItem> orderItems = orderDTO.getOrderItems().stream().map(oi -> oi.toEntity(order)).collect(Collectors.toList());
        order.setOrderItems(orderItems);
        order.setTotalAmount(orderDTO.getTotalAmount());

        Order newOrder = orderRepository.update(order);

        return OrderDTO.toDTO(newOrder);
    }
}
