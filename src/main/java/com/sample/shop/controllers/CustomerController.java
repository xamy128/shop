package com.sample.shop.controllers;

import com.sample.shop.common.controller.Response;
import com.sample.shop.common.controller.RestResponse;
import com.sample.shop.common.controller.RestfulController;
import com.sample.shop.persistence.repositories.CustomerRepository;
import com.sample.shop.persistence.entities.customer.Customer;
import com.sample.shop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Rest Controller for Customer with REST endpoints
 *
 * @author Ammarah Shakeel
 */
@RestController
@RequestMapping("/api/customer")
public class CustomerController extends RestfulController<Customer, String, CustomerRepository> {
    private CustomerService customerService;
    private RestResponse<Customer> restResponse;

    @Autowired
    public CustomerController(CustomerService customerService, RestResponse<Customer> restResponse) {
        this.customerService = customerService;
        this.restResponse = restResponse;
    }

    /**
     * create method for the customer entity
     * @param customer  customer to create
     * @return custom Response with status, customer and message.
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody Customer customer) {
        Response response = restResponse.createSuccessful(customerService.create(customer));
        return new ResponseEntity<>(response, response.getStatus());
    }

    /**
     * update method
     * @param username of the customer to update
     * @param customer to update
     * @return update customer entity
     */
    @RequestMapping(value = "/update/{username}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable String username, @RequestBody Customer customer) {
        Response response = restResponse.updateSuccessful(customerService.update(username, customer));
        return new ResponseEntity<>(response, response.getStatus());
    }
}

