package com.sample.shop;

import com.sample.shop.persistence.entities.order.Order;
import com.sample.shop.persistence.entities.order.OrderItem;
import com.sample.shop.persistence.entities.product.Product;
import com.sample.shop.persistence.repositories.OrderItemRepository;
import com.sample.shop.persistence.repositories.OrderRepository;
import com.sample.shop.persistence.repositories.ProductRepository;
import com.sample.shop.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class OrderServiceTest {
    @Mock
    OrderRepository orderRepository;
    @Mock
    OrderItemRepository orderItemRepository;
    @Mock
    ProductRepository productRepository;
    // Entity to test
    @InjectMocks
    OrderService orderService;

    /**
     * @see OrderService#create(List, List)
     */
    @Test
    public void createOrder_test() {
        List<Integer> productIds = Arrays.asList(2);
        List<Integer> testQuantities = Arrays.asList(5);

        List<Product> testProducts = DataProvider.getProducts();
        Order order = new Order(new BigDecimal(2), 5);
        order.setOrderId(0);

        List<OrderItem> testOrderItems = Arrays.asList(new OrderItem(
                order.getOrderId(),
                0,
                5,
                testProducts.get(0).getId(),
                testProducts.get(0).getPrice()
        ));

        when(productRepository.findAllById(any(List.class))).thenReturn(testProducts);
        when(orderRepository.save(any(Order.class))).thenReturn(order);
        when(orderItemRepository.saveAll(any(List.class))).thenReturn(testOrderItems);
        Order newOrder = orderService.create(productIds, testQuantities);
        assertEquals(order.getOrderId(), newOrder.getOrderId());
    }
}
