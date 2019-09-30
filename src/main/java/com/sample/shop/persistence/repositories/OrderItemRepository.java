package com.sample.shop.persistence.repositories;

import com.sample.shop.persistence.entities.order.OrderItem;
import com.sample.shop.persistence.entities.order.OrderItemKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * For orderItem Entity
 */
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemKey> {
}
