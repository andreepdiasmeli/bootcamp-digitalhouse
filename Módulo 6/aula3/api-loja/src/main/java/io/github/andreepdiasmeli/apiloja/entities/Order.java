package io.github.andreepdiasmeli.apiloja.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.andreepdiasmeli.apiloja.dtos.OrderItemDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private Long id;
    private BigDecimal totalValue;
    private List<OrderItem> orderItems = new ArrayList<>();
    @JsonIgnore
    private Customer customer;
    private Long customerId;
    private static long autoIncrementId = 0;

    public Order() {
    }

    public Order(Customer customer) {
        this.customer = customer;
        this.customerId = customer.getId();
        this.totalValue = BigDecimal.ZERO;
        this.id = autoIncrementId++;
    }

    public Order(Long id, Long customerId, BigDecimal totalValue) {
        this.id = id;
        this.customerId = customerId;
        this.totalValue = totalValue;
        this.id = autoIncrementId++;
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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }
}
