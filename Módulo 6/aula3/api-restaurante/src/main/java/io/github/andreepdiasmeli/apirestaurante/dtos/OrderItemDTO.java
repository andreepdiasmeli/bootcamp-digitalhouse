package io.github.andreepdiasmeli.apirestaurante.dtos;

import io.github.andreepdiasmeli.apirestaurante.entity.Order;
import io.github.andreepdiasmeli.apirestaurante.entity.OrderItem;

import java.math.BigDecimal;

public class OrderItemDTO {

    private Long orderItemId;
    private String description;
    private BigDecimal price;
    private Integer quantity;

    public OrderItemDTO() {
    }

    public OrderItemDTO(Long orderItemId, String description, BigDecimal price, Integer quantity) {
        this.orderItemId = orderItemId;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public static OrderItemDTO toDTO(OrderItem orderItem) {
        return new OrderItemDTO(orderItem.getId(), orderItem.getDescription(), orderItem.getPrice(), orderItem.getQuantity());
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public OrderItem toEntity(Order order) {
        return new OrderItem(description, price, quantity, order, order.getId());
    }
}
