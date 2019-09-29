package com.sample.shop.controllers;

import com.sample.shop.common.controller.Response;
import com.sample.shop.common.controller.RestResponse;
import com.sample.shop.common.controller.RestfulController;
import com.sample.shop.persistence.repositories.OrderRepository;
import com.sample.shop.service.OrderService;
import com.sample.shop.persistence.entities.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.List;

/**
 * REST controller with endpoints for Orders.
 */
@RestController
@RequestMapping("/api/orders")
public class OrderController extends RestfulController<Order, Integer, OrderRepository> {
    private OrderService orderService;
    private RestResponse<Order> restResponse;

    @Autowired
    public OrderController(OrderService orderService, RestResponse<Order> restResponse) {
        super(orderService, restResponse);
        this.orderService = orderService;
        this.restResponse = restResponse;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody Order order)
    {
        throw new NotImplementedException();
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody Order order)
    {
        throw new NotImplementedException();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody List<List<Integer>> data) {
        Response response =  restResponse.createSuccessful(
                orderService.create(
                        data.get(0),
                        data.get(1)
                ));
        return new ResponseEntity<>(response, response.getStatus());
    }
}

