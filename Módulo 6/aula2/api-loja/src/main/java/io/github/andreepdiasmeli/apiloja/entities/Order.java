package io.github.andreepdiasmeli.apiloja.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "\"order\"")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal totalValue;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    private Customer customer;

    public Order() {
    }

    public Order(Customer customer) {
        this.customer = customer;
        this.totalValue = BigDecimal.ZERO;
    }

    public void addOrderItem(OrderItem orderItem){
        this.orderItems.add(orderItem);
        BigDecimal orderItemValue = orderItem.getPrice().multiply(new BigDecimal(orderItem.getQuantity()));
        this.totalValue = this.totalValue.add(orderItemValue);
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Customer getCustomer() {
        return customer;
    }
}
