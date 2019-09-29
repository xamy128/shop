package com.sample.shop.controllers;

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
@RequestMapping("/api/product")
public class ProductController extends RestfulController<Product, Integer, ProductRepository> {
   private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.PUT)
    public Product update(@PathVariable int productId, @RequestBody Product product) {
        return productService.update(productId, product);
    }
}
