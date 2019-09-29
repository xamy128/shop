package com.sample.shop.service;

import com.sample.shop.common.service.TimedCoreService;
import com.sample.shop.persistence.entities.product.Product;
import com.sample.shop.persistence.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Business class for Product entity
 */
@Service
public class ProductService extends TimedCoreService<Product, Integer, ProductRepository> {

    @Autowired
    public ProductService(ProductRepository productRepository) {
        super(productRepository);
    }
}
