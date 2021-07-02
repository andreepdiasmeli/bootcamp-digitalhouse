package io.github.andreepdiasmeli.apiloja.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cpf;

    private String email;

    private String telefone;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    public Customer() {
    }

    public Customer(String name, String cpf, String email, String telefone) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
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
