package io.github.andreepdiasmeli.apirestaurante.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Order {

    private Long id;
    private Long tableId;
    @JsonIgnore
    private Table table;
    private List<OrderItem> orderItems = new ArrayList<>();
    private BigDecimal totalAmount = BigDecimal.ZERO;
    private static long autoIncrementId = 0;
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
    private LocalDateTime createdAt = LocalDateTime.now();

    public Order() {}

    public Order(Table table, Long tableId) {
        this.tableId = tableId;
        this.table = table;
        this.id = autoIncrementId++;
    }

    public Order(Long tableId) {
        this.tableId = tableId;
        this.id = autoIncrementId++;
    }

    private void addTotalAmount(BigDecimal amount){
        this.totalAmount = this.totalAmount.add(amount);
    }

    public void addOrderItem(OrderItem orderItem){
        this.orderItems.add(orderItem);

        BigDecimal totalAmountItem = orderItem.getPrice().multiply(
                new BigDecimal(orderItem.getQuantity()));

        addTotalAmount(totalAmountItem);
        this.table.addTotalAmount(totalAmountItem);
    }

    public Long getId() {
        return id;
    }


    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public Long getTableId() {
        return tableId;
    }

    public Table getTable() {
        return table;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
