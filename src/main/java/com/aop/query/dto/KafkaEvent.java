package com.aop.query.dto;

import com.aop.query.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class KafkaEvent {
    private EventTypes eventType;
    private Product product;
}
