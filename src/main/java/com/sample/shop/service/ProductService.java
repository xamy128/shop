package com.sample.shop.service;

import com.sample.shop.common.service.CoreService;
import com.sample.shop.persistence.entities.product.Product;
import com.sample.shop.persistence.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends CoreService<Product, Integer, ProductRepository> {

}
