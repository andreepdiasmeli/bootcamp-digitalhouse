package io.github.andreepdiasmeli.apirestaurante.dtos;

import io.github.andreepdiasmeli.apirestaurante.entity.Order;
import io.github.andreepdiasmeli.apirestaurante.entity.OrderItem;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

public class OrderItemDTO {

    private String description;
    private BigDecimal price;
    private Integer quantity;

    public OrderItemDTO() {
    }

    public OrderItemDTO(String description, BigDecimal price, Integer quantity) {
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public static OrderItemDTO toDTO(OrderItem orderItem) {
        return new OrderItemDTO(orderItem.getDescription(), orderItem.getPrice(), orderItem.getQuantity());
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
}
