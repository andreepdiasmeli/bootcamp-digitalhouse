package io.github.andreepdiasmeli.apirestaurante.entity;

import javax.persistence.*;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private BigDecimal price;

    private Integer quantity;

    @ManyToOne
    @JoinColumn
    private Order order;

    public OrderItem() {
    }

    public OrderItem(String description, String price, Integer quantity, Order order) {
        this.description = description;
        this.price = new BigDecimal(price);
        this.quantity = quantity;
        this.order = order;
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

    public Order getOrder() {
        return order;
    }
}
