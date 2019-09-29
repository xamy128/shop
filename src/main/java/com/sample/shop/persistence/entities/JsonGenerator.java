package com.sample.shop.persistence.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.shop.persistence.entities.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter @Setter @NoArgsConstructor
public class JsonGenerator {
    List<Product> products = new ArrayList<>();
    List<Integer> quantities;

    public static void main(String[] args) {
Product pro = new Product();
pro.setId(2);
pro.setAvailableQuantity(2);
pro.setIsActive(true);
pro.setName("pro1");
pro.setPrice(new BigDecimal(2));
pro.setProductCategory(Product.ProductCategory.MISCELLANEOUS);
pro.setLastUpdateBy("aa");
//pro.setLastUpdateTime(OffsetDateTime.now());
pro.setLastUpdateBy("aa");
pro.setCreatedBy("aa");
//pro.setCreationTime(OffsetDateTime.now());


    List<Product> pros = new ArrayList<>();
    pros.add(pro);

    List<Integer> quan = Arrays.asList(1);

        JsonGenerator data = new JsonGenerator();
 data.setProducts(pros);
 data.setQuantities(quan);

 TestEntity testEntity = new TestEntity();
 testEntity.setBb(new BigDecimal(20));
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            System.out.println(objectMapper.writeValueAsString(data));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    }

