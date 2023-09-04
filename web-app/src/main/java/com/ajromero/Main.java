package com.ajromero;

import com.ajromero.domain.*;
import com.ajromero.repository.OrderDetailRepository;
import com.ajromero.repository.ProductRepository;
import com.ajromero.repository.PurchaseOrderRepository;
import com.ajromero.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication(scanBasePackages = {"com.ajromero.*"})
public class Main implements CommandLineRunner {
    @Autowired
    IProductService productService;
    @Autowired
    PurchaseOrderRepository orderRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Prueba a ver si furula spring boot");

        showProducts();
    }

    public void showProducts(){

        for(Product p: productService.getProducts()){
            System.out.println(p.getName());
        }
    }
}
