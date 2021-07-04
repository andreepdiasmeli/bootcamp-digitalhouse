package io.github.andreepdiasmeli.apiloja.dtos;

import io.github.andreepdiasmeli.apiloja.entities.Order;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDTO {

    private Long orderId;
    private Long customerId;
    private BigDecimal totalValue;
    private List<OrderItemDTO> orderItems;

    public OrderDTO() {
    }

    public OrderDTO(Long orderId, Long customerId, BigDecimal totalValue, List<OrderItemDTO> orderItems) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.totalValue = totalValue;
        this.orderItems = orderItems;
    }

    public static OrderDTO toDTO(Order order) {
        List<OrderItemDTO> orderItems = order.getOrderItems().stream().map(oi -> OrderItemDTO.toDTO(oi)).collect(Collectors.toList());
        return new OrderDTO(order.getId(), order.getCustomerId(), order.getTotalValue(), orderItems);
    }

    public Long getOrderId() {
        return orderId;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Order toEntity() {
        return new Order(orderId, customerId, totalValue);
    }
}
