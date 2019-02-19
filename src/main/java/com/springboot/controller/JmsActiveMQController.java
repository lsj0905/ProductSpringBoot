package com.springboot.controller;

import com.springboot.service.JmsTeamplateService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jms.Destination;

@Controller
public class JmsActiveMQController {

    @Autowired
    JmsTeamplateService jmsTeamplateService;

    @RequestMapping("/sendMessage")
    public String send(){

        Destination destination = new ActiveMQQueue("TestActiveMQ");

        jmsTeamplateService.sendMessage(destination,"我发送一个消息给消费者");

        return "你好";
    }


}
