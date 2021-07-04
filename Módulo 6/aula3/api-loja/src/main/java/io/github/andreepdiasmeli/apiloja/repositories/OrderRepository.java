package io.github.andreepdiasmeli.apiloja.repositories;

import io.github.andreepdiasmeli.apiloja.entities.Customer;
import io.github.andreepdiasmeli.apiloja.entities.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {

    private final CustomerRepository customerRepository;

    public OrderRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Order> findAll() {
        List<Customer> Customers = customerRepository.loadCustomers();
        return Customers.stream()
                .flatMap(t -> t.getOrders().stream())
                .collect(Collectors.toList());
    }

    public Order findById(Long id) {
        List<Order> orders = findAll();
        return orders.stream().filter(o -> o.getId() == id).findFirst().orElseThrow(() ->
                new RuntimeException("A ordem com id " + id + " não existe.")
        );
    }

    public void deleteById(Long id) {
        List<Customer> Customers = customerRepository.loadCustomers();
        for(Customer Customer : Customers){
            for(Order order : Customer.getOrders()){
                if(order.getId() == id){
                    Customer.getOrders().remove(order);
                    customerRepository.saveAll(Customers);
                    return;
                }
            }
        }
        throw new RuntimeException("A ordem com id " + id + " não existe.");
    }

    public Order create(Order order) {
        List<Customer> Customers = customerRepository.loadCustomers();
        for(Customer Customer : Customers){
            if(Customer.getId() == order.getCustomerId()){
                order.setCustomer(Customer);
                Customer.getOrders().add(order);
                customerRepository.saveAll(Customers);
                return order;
            }
        }
        throw new RuntimeException("O id do cliente informado não existe.");
    }

    public Order update(Order order) {
        List<Customer> Customers = customerRepository.loadCustomers();
        for(Customer Customer : Customers){
            if(Customer.getId() == order.getCustomerId()){
                for(int i = 0; i < Customer.getOrders().size(); i++){
                    Order realOrder = Customer.getOrders().get(i);
                    if(realOrder.getId() == order.getId()){
                        Customer.getOrders().set(i, order);
                        customerRepository.saveAll(Customers);
                        return order;
                    }
                }
            }
        }
        throw new RuntimeException("O id do cliente ou pedidoo informado não existe.");
    }
}
