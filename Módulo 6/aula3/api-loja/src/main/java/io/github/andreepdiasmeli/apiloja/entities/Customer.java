package io.github.andreepdiasmeli.apiloja.entities;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String telefone;
    private List<Order> orders = new ArrayList<>();
    private static long autoIncrementId = 0;

    public Customer() {
    }

    public Customer(String name, String cpf, String email, String telefone) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.id = autoIncrementId++;
    }

    public void addOrder(Order order){
        this.orders.add(order);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
