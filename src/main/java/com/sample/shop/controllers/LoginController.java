package com.sample.shop.controllers;

import com.sample.shop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Controller with login REST endpoints.
 */
@RestController
@RequestMapping("/api")
public class LoginController {
    private CustomerService customerService;

    @Autowired
    public LoginController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.GET)
    public ResponseEntity login(@RequestParam String username, @RequestParam String password) {
        return new ResponseEntity<>(customerService.authenticate(username, password), HttpStatus.OK);
    }
}
