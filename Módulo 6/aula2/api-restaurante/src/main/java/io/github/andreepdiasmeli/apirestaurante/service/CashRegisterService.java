package io.github.andreepdiasmeli.apirestaurante.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CashRegisterService {

    private BigDecimal totalAmount;

    public CashRegisterService() {
        totalAmount = BigDecimal.ZERO;
    }

    public void addAmount(BigDecimal totalTableAmount) {
        this.totalAmount = this.totalAmount.add(totalTableAmount);
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
}
