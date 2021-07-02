package io.github.andreepdiasmeli.apirestaurante.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@javax.persistence.Table(name = "\"table\"")
public class Table {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "table", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action= OnDeleteAction.CASCADE)
    private List<Order> orders = new ArrayList<>();

    private BigDecimal totalAmount = BigDecimal.ZERO;

    public Table() {
    }

    public Long getId() {
        return id;
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public void addTotalAmount(BigDecimal amount){
        this.totalAmount = this.totalAmount.add(amount);
    }

    public void resetTotalAmount(){
        this.totalAmount = BigDecimal.ZERO;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
}
