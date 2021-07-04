package io.github.andreepdiasmeli.apirestaurante.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

public class OrderItem {

    private Long id;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private Long orderId;
    @JsonIgnore
    private Order order;
    private static long autoIncrementId = 0;

    public OrderItem() {
        this.id = autoIncrementId++;
    }

    public OrderItem(String description, BigDecimal price, Integer quantity, Order order, Long orderId) {
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.orderId = orderId;
        this.order = order;
        this.id = autoIncrementId++;
    }

    public Long getId() {
        return id;
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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
