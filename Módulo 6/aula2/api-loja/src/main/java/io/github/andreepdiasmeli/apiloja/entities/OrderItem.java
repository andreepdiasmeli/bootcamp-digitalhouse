package io.github.andreepdiasmeli.apiloja.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Integer quantity;

    private String color;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn
    private Order order;

    public OrderItem() {
    }

    public OrderItem(String description, Integer quantity, String color, String price, Order order) {
        this.description = description;
        this.quantity = quantity;
        this.color = color;
        this.price = new BigDecimal(price);
        this.order = order;
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
}
