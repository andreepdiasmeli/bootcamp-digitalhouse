package io.github.andreepdiasmeli.apiloja.dtos;

import io.github.andreepdiasmeli.apiloja.entities.Order;
import io.github.andreepdiasmeli.apiloja.entities.OrderItem;

import java.math.BigDecimal;

public class OrderItemDTO {

    private Long orderItemId;
    private Long orderId;
    private String description;
    private Integer quantity;
    private String color;
    private BigDecimal price;

    public OrderItemDTO() {
    }

    public OrderItemDTO(String description, Integer quantity, String color, BigDecimal price, Long orderItemId, Long orderId) {
        this.description = description;
        this.quantity = quantity;
        this.color = color;
        this.price = price;
        this.orderItemId = orderItemId;
        this.orderId = orderId;
    }

    public static OrderItemDTO toDTO(OrderItem orderItem) {
        return new OrderItemDTO(orderItem.getDescription(), orderItem.getQuantity(), orderItem.getColor(), orderItem.getPrice(), orderItem.getId(), orderItem.getOrderId());
    }

    public String getDescription() {
        return description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getColor() {
        return color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderItem toEntity(Order order) {
        return new OrderItem(description, quantity, color, price, order, order.getId());
    }
}
