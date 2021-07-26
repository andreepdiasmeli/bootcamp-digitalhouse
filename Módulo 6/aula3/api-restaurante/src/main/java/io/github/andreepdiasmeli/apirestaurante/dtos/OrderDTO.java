package io.github.andreepdiasmeli.apirestaurante.dtos;

import io.github.andreepdiasmeli.apirestaurante.entity.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDTO {

    private Long orderId;
    private List<OrderItemDTO> orderItems;
    private BigDecimal totalAmount;
    private Long tableId;
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
    private LocalDateTime createdAt;

    public OrderDTO() {
    }

    public OrderDTO(Long orderId, List<OrderItemDTO> orderItems, BigDecimal totalAmount, Long tableId, LocalDateTime createdAt) {
        this.orderId = orderId;
        this.orderItems = orderItems;
        this.totalAmount = totalAmount;
        this.tableId = tableId;
        this.createdAt = createdAt;
    }

    public static OrderDTO toDTO(Order order) {
        List<OrderItemDTO> orderItems = order.getOrderItems().stream().map(o -> OrderItemDTO.toDTO(o)).collect(Collectors.toList());
        return new OrderDTO(order.getId(), orderItems, order.getTotalAmount(), order.getTable().getId(), order.getCreatedAt());
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getTableId() {
        return tableId;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public Order toEntity() {
        return new Order(tableId);
    }
}
