package com.dongverine.component;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(String topic, String payload) {
        kafkaTemplate.send(topic, payload);
        log.info("Message: " + payload + " sent to topic: " + topic);
    }


//    @Scheduled(fixedRate = 3000)
//    public void reportCurrentTime() {
//        send("GameLog", "helloworld " + dateFormat.format(new Date()));
//    }

    @KafkaListener(topics = "GameLog")
    public void receiveTopic1(ConsumerRecord consumerRecord) {
    	log.info("####"+consumerRecord.value());
        log.info("Receiver on topic1: "+consumerRecord.toString());
    }
}
