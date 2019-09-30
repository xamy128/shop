package com.sample.shop.controllers;

import com.sample.shop.common.controller.Response;
import com.sample.shop.common.controller.RestResponse;
import com.sample.shop.common.controller.RestfulController;
import com.sample.shop.persistence.entities.customer.CustomerAddress;
import com.sample.shop.persistence.repositories.CustomerRepository;
import com.sample.shop.persistence.entities.customer.Customer;
import com.sample.shop.service.CustomerService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.List;

/**
 * Rest Controller for Customer with REST endpoints
 *
 * @author Ammarah Shakeel
 */
@RestController
@RequestMapping("/api/customers")
public class CustomerController extends RestfulController<Customer, String, CustomerRepository> {
    private CustomerService customerService;
    private RestResponse<Customer> restResponse;

    @Autowired
    public CustomerController(CustomerService customerService, RestResponse<Customer> restResponse) {
        super(customerService, restResponse);
        this.customerService = customerService;
        this.restResponse = restResponse;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody Customer customer) {
        throw new NotImplementedException();
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody Customer customer) {
        throw new NotImplementedException();
    }

    /**
     * create method for the customer entity
     * @param data to create
     * @return custom Response with status, customer and message.
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody Data data) {
        Customer customer = customerService.create(data.customer, data.addresses);
        Response response = restResponse.createSuccessful(customer);
        return new ResponseEntity<>(response, response.getStatus());
    }

    /**
     * update method
     * @param username of the customer to update
     * @param data to update
     * @return update customer entity
     */
    @RequestMapping(value = "/update/{username}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable String username, @RequestBody Data data) {
        Customer customer = customerService.update(username, data.customer, data.addresses);
        Response response = restResponse.updateSuccessful(customer);
        return new ResponseEntity<>(response, response.getStatus());
    }
}

/**
 * Data class to all customer related information
 */
@NoArgsConstructor
@Getter
@Setter
class Data{
    Customer customer;
    List<CustomerAddress> addresses;
}


