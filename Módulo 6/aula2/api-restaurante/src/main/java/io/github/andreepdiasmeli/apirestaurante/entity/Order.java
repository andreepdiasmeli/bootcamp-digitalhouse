package io.github.andreepdiasmeli.apirestaurante.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@javax.persistence.Table(name="\"order\"")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Table table;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
    @OnDelete(action= OnDeleteAction.CASCADE)
    private List<OrderItem> orderItems = new ArrayList<>();

    private BigDecimal totalAmount = BigDecimal.ZERO;

    public Order() {}

    public Order(Table table) {
        this.table = table;
    }

    private void addTotalAmount(BigDecimal amount){
        this.totalAmount = this.totalAmount.add(amount);
    }

    public void addOrderItem(OrderItem orderItem){
        this.orderItems.add(orderItem);

        BigDecimal totalAmountItem = orderItem.getPrice().multiply(
                new BigDecimal(orderItem.getQuantity())
        );

        addTotalAmount(totalAmountItem);
        this.table.addTotalAmount(totalAmountItem);
    }

    public Long getId() {
        return id;
    }

    public Table getTable() {
        return table;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
}
