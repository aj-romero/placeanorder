package com.ajromero.service;

import com.ajromero.domain.entity.Product;

import java.util.List;

public interface IProductService {

    List<Product> getProducts();

    Product findById(Integer id);

    Product save(Product product);
}
