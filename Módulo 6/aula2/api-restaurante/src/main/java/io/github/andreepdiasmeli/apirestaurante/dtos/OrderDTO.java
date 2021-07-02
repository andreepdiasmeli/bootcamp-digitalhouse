package io.github.andreepdiasmeli.apirestaurante.dtos;

import io.github.andreepdiasmeli.apirestaurante.entity.Order;
import io.github.andreepdiasmeli.apirestaurante.entity.OrderItem;
import io.github.andreepdiasmeli.apirestaurante.entity.Table;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDTO {

    private List<OrderItemDTO> orderItems;
    private BigDecimal totalAmount;

    public OrderDTO() {
    }

    public OrderDTO(List<OrderItemDTO> orderItems, BigDecimal totalAmount) {
        this.orderItems = orderItems;
        this.totalAmount = totalAmount;
    }

    public static OrderDTO toDTO(Order order) {
        List<OrderItemDTO> orderItems = order.getOrderItems().stream().map(o -> OrderItemDTO.toDTO(o)).collect(Collectors.toList());
        return new OrderDTO(orderItems, order.getTotalAmount());
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
}
