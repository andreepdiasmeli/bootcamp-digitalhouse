package io.github.andreepdiasmeli.apirestaurante.dtos;

import java.math.BigDecimal;
import java.util.List;

public class TableInfoDTO {

    private Long tableId;
    private BigDecimal currentTotalAmount;
    private List<OrderDTO> order;

    public TableInfoDTO(Long tableId, BigDecimal currentTotalAmount, List<OrderDTO> order) {
        this.tableId = tableId;
        this.currentTotalAmount = currentTotalAmount;
        this.order = order;
    }

    public Long getTableId() {
        return tableId;
    }

    public BigDecimal getCurrentTotalAmount() {
        return currentTotalAmount;
    }

    public List<OrderDTO> getOrder() {
        return order;
    }
}
