package com.example.demo.business;

import org.springframework.stereotype.Service;

@Service
public class ProductBusiness {
    public String getProductById(String id) {
        return id;
    }
}
