package io.github.andreepdiasmeli.apiloja.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

public class OrderItem {

    private Long id;
    private String description;
    private Integer quantity;
    private String color;
    private BigDecimal price;
    @JsonIgnore
    private Order order;
    private Long orderId;
    private static long autoIncrementId = 0;

    public OrderItem() {
    }

    public OrderItem(String description, Integer quantity, String color, BigDecimal price, Order order, Long orderId) {
        this.description = description;
        this.quantity = quantity;
        this.color = color;
        this.price = price;
        this.order = order;
        this.orderId = orderId;
        this.id = autoIncrementId++;
    }

    public Long getId() {
        return id;
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

    public Order getOrder() {
        return order;
    }

    public Long getOrderId() {
        return orderId;
    }


    public void setOrder(Order order) {
        this.order = order;
    }
}
