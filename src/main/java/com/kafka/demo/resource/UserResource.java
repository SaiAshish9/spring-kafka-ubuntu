package com.kafka.demo.resource;

import com.kafka.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class UserResource {

//    @Autowired
//    KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    KafkaTemplate<String, User> kafkaTemplate;

    private static final String TOPIC="Kafka_Example";

    @GetMapping("/publish/{message}")
    public String post(@PathVariable("message") final String message){
//        kafkaTemplate.send(TOPIC,message);

        kafkaTemplate.send(TOPIC,new User(message,"Tech",20000L));
        return "Published successfully";

    }


}
