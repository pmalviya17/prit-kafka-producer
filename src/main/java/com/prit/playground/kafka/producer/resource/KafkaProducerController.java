package com.prit.playground.kafka.producer.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class KafkaProducerController {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    public static final String TOPIC = "KafkaExampleTopic";

    @GetMapping("/publish/{message}")
    public String postMessage(@PathVariable("message") final String message){
        kafkaTemplate.send(TOPIC, message);
      return "Published Successfully";
    }
}
