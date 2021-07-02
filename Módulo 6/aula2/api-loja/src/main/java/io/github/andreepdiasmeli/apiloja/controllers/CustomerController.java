package io.github.andreepdiasmeli.apiloja.controllers;

import io.github.andreepdiasmeli.apiloja.dtos.OrderDTO;
import io.github.andreepdiasmeli.apiloja.dtos.OrderItemDTO;
import io.github.andreepdiasmeli.apiloja.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("{id}")
    public List<OrderDTO> getOrders(@PathVariable Long id){
        List<OrderDTO> orders = null;
        try{
            orders = customerService.getOrders(id);
        }catch (RuntimeException ex){
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, ex.getMessage());
        }
        return orders;
    }
}
