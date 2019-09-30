package com.sample.shop.persistence.repositories;

import com.sample.shop.persistence.entities.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * For order entity
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
