package com.ajromero.mapper;

import com.ajromero.domain.dto.ProductDto;
import com.ajromero.domain.entity.Product;
import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoMapper implements Function<Product, ProductDto> {
    @Override
    public ProductDto apply(Product product) {
        return new ProductDto(product.getId(),
                                product.getCode(),
                                product.getName(),
                                product.getPrice());
    }
}
