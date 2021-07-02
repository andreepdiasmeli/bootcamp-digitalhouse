package io.github.andreepdiasmeli.apiloja.dtos;

import io.github.andreepdiasmeli.apiloja.entities.OrderItem;

import java.math.BigDecimal;

public class OrderItemDTO {

    private String description;
    private Integer quantity;
    private String color;
    private BigDecimal price;

    public OrderItemDTO() {
    }

    public OrderItemDTO(String description, Integer quantity, String color, BigDecimal price) {
        this.description = description;
        this.quantity = quantity;
        this.color = color;
        this.price = price;
    }

    public static OrderItemDTO toDTO(OrderItem orderItem) {
        return new OrderItemDTO(orderItem.getDescription(), orderItem.getQuantity(), orderItem.getColor(), orderItem.getPrice());
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
}
