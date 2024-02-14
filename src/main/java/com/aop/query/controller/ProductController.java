package com.aop.query.controller;

import com.aop.query.model.Product;
import com.aop.query.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin("**")
@RequestMapping(path = "api/v1/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getProducts() {

        return productService.getAllProdoucts();
    }
}
