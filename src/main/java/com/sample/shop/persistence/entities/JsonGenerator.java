package com.sample.shop.persistence.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.shop.persistence.entities.product.Product;
import com.sample.shop.persistence.entities.product.ProductCategory;
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

        List<List<Integer>> data = Arrays.asList(Arrays.asList(3,4,5),
                Arrays.asList(10,10,10));

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            System.out.println(objectMapper.writeValueAsString(data));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    }

