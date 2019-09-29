package com.sample.shop.controllers;

import com.sample.shop.common.controller.RestResponse;
import com.sample.shop.common.controller.RestfulController;
import com.sample.shop.persistence.repositories.ProductRepository;
import com.sample.shop.service.ProductService;
import com.sample.shop.persistence.entities.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Rest controller with endpoints for products
 */
@RestController
@RequestMapping("/api/products")
public class ProductController extends RestfulController<Product, Integer, ProductRepository> {
    @Autowired
    public ProductController(ProductService productService, RestResponse<Product> restResponse) {
        super(productService, restResponse);
    }
}
