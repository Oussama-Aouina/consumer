package com.aop.query.service;

import com.aop.query.model.Product;
import com.aop.query.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaService {
    @Autowired
    private ProductRepo productRepo;

//    @KafkaListener(topics ="stock",groupId ="sells")
//    public void consumeMessage(String msg){
//        log.info(format("the consumed message is::%s",msg));
//    }

    @KafkaListener(topics = "stock",groupId = "sells")
    public void consumeMessage(Product product){
        productRepo.save(product);
        log.info(format("product: %s is saved successfully"));
    }

}

