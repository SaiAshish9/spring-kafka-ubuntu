package com.kafka.demo.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "Kafka_Example",containerFactory = "kafkaListenerFactory")
    public void consume(String message){
        System.out.println("Consumer message: "+ message);
    }


}
