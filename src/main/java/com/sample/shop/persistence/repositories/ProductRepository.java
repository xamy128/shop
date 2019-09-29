package com.sample.shop.persistence.repositories;

import com.sample.shop.persistence.entities.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select p from Product p where lower(p.name) like ?1 or p.isActive like ?2")
     List<Product> find(String parameter, Boolean isActive
    );
}
