package com.ajromero.mapper;

import com.ajromero.domain.entity.Product;
import com.ajromero.domain.ProductDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ProductDtoMapper implements Function<Product, ProductDto> {
    @Override
    public ProductDto apply(Product product) {
        return new ProductDto(product.getId(), product.getCode(), product.getName(), product.getPrice());
    }
}
