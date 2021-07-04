package io.github.andreepdiasmeli.apirestaurante.controller;

import io.github.andreepdiasmeli.apirestaurante.service.CashRegisterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cash-register")
public class CashRegisterController {

    private final CashRegisterService cashRegisterService;

    public CashRegisterController(CashRegisterService cashRegisterService) {
        this.cashRegisterService = cashRegisterService;
    }

    @GetMapping
    public BigDecimal getTotalCashRegiserAmount(){
        return cashRegisterService.getTotalAmount();
    }
}
