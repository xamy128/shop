package com.sample.shop.controllers;

import com.sample.shop.persistence.entities.customer.Customer;
import com.sample.shop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Controller with login REST endpoints.
 */
@RestController("/api")
public class LoginController {
    private CustomerService customerService;

    @Autowired
    public LoginController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public Customer login(@RequestParam String username, @RequestParam String password) {
        return customerService.authenticate(username, password);
    }

}
