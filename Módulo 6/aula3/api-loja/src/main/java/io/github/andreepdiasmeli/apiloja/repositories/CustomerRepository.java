package io.github.andreepdiasmeli.apiloja.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.github.andreepdiasmeli.apiloja.entities.Customer;
import io.github.andreepdiasmeli.apiloja.entities.Order;
import io.github.andreepdiasmeli.apiloja.entities.OrderItem;
import org.springframework.stereotype.Repository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Repository
public class CustomerRepository {

    public CustomerRepository() {
    }

    public List<Customer> loadCustomers(){
        List<Customer> customers = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File("src/main/resources/database/customers.json");
            customers = Arrays.asList(mapper.readValue(file, Customer[].class));

            for(Customer customer : customers){
                for(Order order : customer.getOrders()){
                    for(OrderItem orderItem : order.getOrderItems()){
                        orderItem.setOrder(order);
                    }
                    order.setCustomer(customer);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Falha ao abrir o arquivo Customers.json .");
        }
        return customers;
    }

    public void saveCustomers(List<Customer> Customers){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            String path = "src/main/resources/database/customers.json";
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter out = new BufferedWriter(fileWriter);
            String customersJSONString = objectMapper.writeValueAsString(Customers);
            out.write(customersJSONString);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Customer findById(Long id) {
        List<Customer> customers = loadCustomers();
        return filterById(id, customers);
    }

    private Customer filterById(Long id, List<Customer> customers) {
        return customers.stream().filter(t -> t.getId() == id).findFirst().orElseThrow(() ->
                new RuntimeException("Cliente com id " + id + " não foi encontrado.")
        );
    }

    public void save(Customer Customer) {
        List<Customer> customers = loadCustomers();
        Customer persistedCustomer = filterById(Customer.getId(), customers);
        Integer persistedCustomerIndex = customers.indexOf(persistedCustomer);
        customers.set(persistedCustomerIndex, Customer);
        saveAll(customers);
    }

    public void saveAll(List<Customer> customers) {
        saveCustomers(customers);
    }
}
