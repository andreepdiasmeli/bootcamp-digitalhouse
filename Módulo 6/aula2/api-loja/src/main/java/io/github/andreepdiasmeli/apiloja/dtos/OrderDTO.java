package io.github.andreepdiasmeli.apiloja.dtos;

import io.github.andreepdiasmeli.apiloja.entities.Order;
import io.github.andreepdiasmeli.apiloja.entities.OrderItem;

import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDTO {

    private Long id;
    private BigDecimal totalValue;
    private List<OrderItemDTO> orderItems;

    public OrderDTO() {
    }

    public OrderDTO(Long id, BigDecimal totalValue, List<OrderItemDTO> orderItems) {
        this.id = id;
        this.totalValue = totalValue;
        this.orderItems = orderItems;
    }

    public static OrderDTO toDTO(Order order) {
        List<OrderItemDTO> orderItems = order.getOrderItems().stream().map(oi -> OrderItemDTO.toDTO(oi)).collect(Collectors.toList());
        return new OrderDTO(order.getId(), order.getTotalValue(), orderItems);
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }
}
