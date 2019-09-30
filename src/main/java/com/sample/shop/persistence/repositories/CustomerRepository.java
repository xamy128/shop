package com.sample.shop.persistence.repositories;

import com.sample.shop.persistence.entities.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * For customer entity
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

     @Query("Select c from Customer c where c.username = ?1 and c.password = ?2")
     Optional<Customer> authenticate(String username, String password);
}
