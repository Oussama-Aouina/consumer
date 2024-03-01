package com.aop.query.service;

import com.aop.query.model.Product;
import com.aop.query.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo ;

    public List<Product> getAllProdoucts() {
        return productRepo.findAll();
    }

    public void addProduct(Product product) {
        productRepo.save(product);
    }

    public Optional<Product> getProduct(String id) {
        Optional<Product> product = productRepo.findById(id);
        return product;
    }
}
