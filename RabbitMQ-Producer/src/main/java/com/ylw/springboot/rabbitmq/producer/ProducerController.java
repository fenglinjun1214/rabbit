package com.ylw.springboot.rabbitmq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    @Autowired
    private FanoutProducer fanoutProducer;

    @PostMapping("/sendFanout")
    public String sendFanout(@RequestParam String queueName) {
        fanoutProducer.send(queueName);
        return "success";
    }
}
