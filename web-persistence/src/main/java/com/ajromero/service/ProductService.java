package com.ajromero.service;

import com.ajromero.domain.entity.Product;
import com.ajromero.domain.entity.PurchaseOrder;
import com.ajromero.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        if (productRepository.findById(id).isPresent()) {
            return productRepository.findById(id).orElseThrow();
        }
        return null;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public ServiceResponse updateInventory(PurchaseOrder order) {
        order.getProducts().forEach(detail -> {
            Product product = detail.getProduct();
            product.adjustStock(detail.getQuantity());
            this.save(product);
        });

        return  commitOrder(order);
    }

    private ServiceResponse commitOrder(PurchaseOrder order) {
        ServiceResponse resp = new ServiceResponse();
        resp.setMessage("Inventory Updated");
        resp.setSuccess(true);
        resp.setFundReservedCode(order.getFundReservedCode());
        resp.setOrderId(order.getId());
        resp.setPaymentCode(order.getPaymentCode());
        return resp;
    }
}
