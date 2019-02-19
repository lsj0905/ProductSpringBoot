package com.springboot.service.imp;

import com.springboot.service.JmsTeamplateService;
import org.apache.activemq.broker.region.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;


@Component
public class JmsTeamplateServiceImpl implements JmsTeamplateService {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Override
    public void sendMessage(javax.jms.Destination destination, String message) {

        this.jmsMessagingTemplate.convertAndSend(destination,message);
    }
}
