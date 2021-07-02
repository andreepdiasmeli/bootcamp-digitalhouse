package io.github.andreepdiasmeli.apiloja.repositories;

import io.github.andreepdiasmeli.apiloja.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
