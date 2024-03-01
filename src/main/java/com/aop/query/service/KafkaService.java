package com.aop.query.service;

import com.aop.query.dto.EventTypes;
import com.aop.query.dto.KafkaEvent;
import com.aop.query.model.Product;
import com.aop.query.repository.ProductRepo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaService {
    @Autowired
    private ProductRepo productRepo;

    @KafkaListener(topics ="stock",groupId ="sells")
    /*public void consumeMessage(String msg){
        log.info(format("the consumed message is::%s",msg));

        //this code is to deserilize the json object "Product" received/consumed as a string
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonParser parser = mapper.createParser(msg);
            Product product =  parser.readValueAs(Product.class);
            log.info(format("json product: %s",product));
            productRepo.save(product);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
*/

    @KafkaListener(topics = "stock2",groupId = "sells")
    public void consumeMessage(String msg){
        try {
            //the jason deserializer:
            ObjectMapper mapper = new ObjectMapper();
            JsonParser parser = mapper.createParser(msg);
            KafkaEvent kafkaEvent =  parser.readValueAs(KafkaEvent.class);
            //the CRUD opreations:
            if (kafkaEvent.getEventType().equals(EventTypes.updateProduct)) {
                Product old = productRepo.findById(kafkaEvent.getProduct().getId()).get();
                old.setName(kafkaEvent.getProduct().getName());
                old.setDescription(kafkaEvent.getProduct().getDescription());
                old.setPrice(kafkaEvent.getProduct().getPrice());
                productRepo.save(old);
            } else if (kafkaEvent.getEventType().equals(EventTypes.addProduct)) {
                productRepo.save(kafkaEvent.getProduct());
            }
            else if (kafkaEvent.getEventType().equals(EventTypes.deleteProduct)) {
                productRepo.delete(kafkaEvent.getProduct());
            }
        }catch (Exception e){
            System.out.println(e.getCause());
        }
    }

}

