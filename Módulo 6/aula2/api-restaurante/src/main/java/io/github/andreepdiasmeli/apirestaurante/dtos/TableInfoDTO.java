package io.github.andreepdiasmeli.apirestaurante.dtos;

import java.math.BigDecimal;
import java.util.List;

public class TableInfoDTO {

    private BigDecimal currentTotalAmount;
    private List<OrderDTO> orderItems;

    public TableInfoDTO(BigDecimal currentTotalAmount, List<OrderDTO> orderItems) {
        this.currentTotalAmount = currentTotalAmount;
        this.orderItems = orderItems;
    }

    public BigDecimal getCurrentTotalAmount() {
        return currentTotalAmount;
    }

    public List<OrderDTO> getOrderItems() {
        return orderItems;
    }
}
