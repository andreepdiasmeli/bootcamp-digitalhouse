package io.github.andreepdiasmeli.apiloja.services;

import io.github.andreepdiasmeli.apiloja.dtos.OrderDTO;
import io.github.andreepdiasmeli.apiloja.entities.Customer;
import io.github.andreepdiasmeli.apiloja.entities.Order;
import io.github.andreepdiasmeli.apiloja.repositories.CustomerRepository;
import io.github.andreepdiasmeli.apiloja.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private Customer getById(Long id) {
        return customerRepository.findById(id);
    }

    public List<OrderDTO> getOrders(Long id) {
        Customer customer = getById(id);
        List<Order> orders = customer.getOrders();
        return orders.stream().map(o -> OrderDTO.toDTO(o)).collect(Collectors.toList());
    }
}
