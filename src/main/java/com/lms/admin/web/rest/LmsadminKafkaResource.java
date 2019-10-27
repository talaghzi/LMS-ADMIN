package com.lms.admin.web.rest;

import com.lms.admin.service.LmsadminKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lmsadmin-kafka")
public class LmsadminKafkaResource {

    private final Logger log = LoggerFactory.getLogger(LmsadminKafkaResource.class);

    private LmsadminKafkaProducer kafkaProducer;

    public LmsadminKafkaResource(LmsadminKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
