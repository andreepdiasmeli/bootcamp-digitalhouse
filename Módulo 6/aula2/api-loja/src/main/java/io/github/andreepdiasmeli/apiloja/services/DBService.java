package io.github.andreepdiasmeli.apiloja.services;

import io.github.andreepdiasmeli.apiloja.dtos.OrderItemDTO;
import io.github.andreepdiasmeli.apiloja.entities.Customer;
import io.github.andreepdiasmeli.apiloja.entities.Order;
import io.github.andreepdiasmeli.apiloja.entities.OrderItem;
import io.github.andreepdiasmeli.apiloja.repositories.CustomerRepository;
import io.github.andreepdiasmeli.apiloja.repositories.OrderItemRepository;
import io.github.andreepdiasmeli.apiloja.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBService {

    private CustomerRepository customerRepository;

    public DBService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void instantiateDB(){
        Customer c1 = new Customer("André", "073459", "andre.ddias@meli.com", "99233");
        Customer c2 = new Customer("Eduardo", "657008", "andre.ddias@gmail.com", "32662");

        Order o1 = new Order(c1);
        Order o2 = new Order(c1);
        Order o3 = new Order(c2);

        c1.addOrder(o1);
        c1.addOrder(o2);
        c2.addOrder(o3);

        OrderItem oi1 = new OrderItem("Suporte Macbook", 1, "Metálico", "120.00", o1);
        OrderItem oi2 = new OrderItem("Webcam Logitech", 1, "Preta", "999.00", o1);
        OrderItem oi3 = new OrderItem("Estante de Livros", 1, "Madeira", "299.00", o2);
        OrderItem oi4 = new OrderItem("Mesa de escritório", 1, "Preta", "399.00", o2);
        OrderItem oi5 = new OrderItem("Copo Térmico", 2, "Branco", "79.00", o3);
        OrderItem oi6 = new OrderItem("Cafeteira", 1, "Preta", "149.00", o3);

        o1.addOrderItem(oi1);
        o1.addOrderItem(oi2);
        o2.addOrderItem(oi3);
        o2.addOrderItem(oi4);
        o3.addOrderItem(oi5);
        o3.addOrderItem(oi6);

        customerRepository.saveAll(List.of(c1, c2));
    }
}
