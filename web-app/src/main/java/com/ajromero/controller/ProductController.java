package com.ajromero.controller;

import com.ajromero.domain.dto.ProductDto;
import com.ajromero.mapper.ProductDtoMapper;
import com.ajromero.service.IProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/v1/products")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    IProductService productService;
    @Autowired
    ProductDtoMapper productDtoMapper;

    @GetMapping
    public ResponseEntity<List<ProductDto>> list() {
        List<ProductDto> result = productService.getProducts()
                                    .stream()
                                    .map(productDtoMapper)
                                    .toList();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
