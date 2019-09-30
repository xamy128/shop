package com.sample.shop.service;

import com.sample.shop.common.service.TimedCoreService;
import com.sample.shop.persistence.entities.order.Order;
import com.sample.shop.persistence.entities.order.OrderItem;
import com.sample.shop.persistence.entities.product.Product;
import com.sample.shop.persistence.repositories.OrderItemRepository;
import com.sample.shop.persistence.repositories.OrderRepository;
import com.sample.shop.persistence.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Business logic for order
 *
 * @author Ammarah.Shakeel
 */
@Service
public class OrderService extends TimedCoreService<Order, Integer, OrderRepository> {
    private OrderRepository orderRepository;
    private OrderItemRepository orderItemRepository;
    private ProductRepository productRepository;

    @Autowired
    public OrderService(
            OrderRepository orderRepository,
            OrderItemRepository orderItemRepository,
            ProductRepository productRepository
    ) {
        super(orderRepository);
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;
    }

    /**
     * Create Order from products selected by customer
     * @param productIds Ids of the selected products
     * @param quantities Selected quantity of each product
     * @return created Order
     */
    public Order create(List<Integer> productIds, List<Integer> quantities) {
        List<Product> products = productRepository.findAllById(productIds);
        BigDecimal totalPrice = products
                .stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Integer totalQuantity = products.stream()
                .mapToInt(Product::getAvailableQuantity)
                .sum();

        Order order = new Order(totalPrice, totalQuantity);

        Order newOrder = orderRepository.save(order);
        List<OrderItem> items = IntStream
                .range(0, quantities.size()).mapToObj(it ->
                        new OrderItem(
                                newOrder.getOrderId(),
                                it,
                                quantities.get(it),
                                products.get(it).getId(),
                                products.get(it).getPrice()
                        )
                ).collect(Collectors.toList());
        orderItemRepository.saveAll(items);
        return newOrder;
    }
}
