package io.github.andreepdiasmeli.apirestaurante.controller;

import io.github.andreepdiasmeli.apirestaurante.dtos.OrderDTO;
import io.github.andreepdiasmeli.apirestaurante.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("all")
    public List<OrderDTO> getAll(){
        return orderService.findAll();
    }

    @GetMapping("{id}")
    public OrderDTO get(@PathVariable Long id){
        OrderDTO order = null;
        try{
            order = orderService.findById(id);
        }catch (RuntimeException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
        return order;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        try{
            orderService.deleteById(id);
        }catch (RuntimeException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @PostMapping
    public OrderDTO create(@RequestBody OrderDTO order){
        OrderDTO orderDTO = null;
        try {
            orderDTO =  orderService.create(order);
        }catch (RuntimeException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
        return orderDTO;
    }

    @PutMapping("{id}")
    public OrderDTO update(@PathVariable Long id, @RequestBody OrderDTO order){
        OrderDTO orderDTO = null;
        try {
            orderDTO =  orderService.update(order);
        }catch (RuntimeException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
        return orderDTO;
    }
/*

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDTO put(Long id){
        return orderService.update(id);
    }


    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        return orderService.delete(id);
    }
    */

}
