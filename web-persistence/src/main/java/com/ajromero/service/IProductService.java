package com.ajromero.service;

import com.ajromero.domain.entity.Product;
import com.ajromero.domain.entity.PurchaseOrder;

import java.util.List;

public interface IProductService {

    List<Product> getProducts();

    Product findById(Integer id);

    Product save(Product product);

    ServiceResponse updateInventory(PurchaseOrder order);
}

