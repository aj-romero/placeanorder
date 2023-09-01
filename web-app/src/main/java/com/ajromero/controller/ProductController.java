package com.ajromero.controller;

import com.ajromero.domain.Product;
import com.ajromero.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    IProductService productService;
    @GetMapping
    public ResponseEntity<List<Product>> list() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }
}
