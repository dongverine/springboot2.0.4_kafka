package com.dongverine.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestController {
    @Autowired
    private KafkaTemplate kafkaTemplate;
    
	@ResponseBody
	@RequestMapping("/input")
	public void call() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String topic = "GameLog";
		kafkaTemplate.send(topic, "helloworld " + dateFormat.format(new Date()));
	}
}
