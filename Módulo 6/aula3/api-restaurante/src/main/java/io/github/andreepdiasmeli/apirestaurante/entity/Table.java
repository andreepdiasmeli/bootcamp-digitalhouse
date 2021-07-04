package io.github.andreepdiasmeli.apirestaurante.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Table {

    private Long id;
    private List<Order> orders = new ArrayList<>();
    private BigDecimal totalAmount = BigDecimal.ZERO;
    private static long autoIncrementId = 0;

    public Table() {
        this.id = autoIncrementId++;
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
