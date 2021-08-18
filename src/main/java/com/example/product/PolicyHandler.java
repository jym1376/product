package com.example.product;

import com.example.product.DeliveryStarted;
import com.example.product.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler {
    @Autowired ProductRepository productRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryStarted_DecreaseProduct(@Payload DeliveryStarted deliveryStarted){

        if(!deliveryStarted.validate()) return;

        System.out.println("\n\n##### listener DecreaseProduct : " + deliveryStarted.toJson() + "\n\n");

        // Sample Logic //
        java.util.Optional<Product> optionalProduct = productRepository.findById(deliveryStarted.getProductId());
        Product product = optionalProduct.get();
        product.setStock(product.getStock()-1);
        productRepository.save(product);
    
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}
}
