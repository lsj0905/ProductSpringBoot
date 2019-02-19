package com.springboot.service;

public interface JmsTeamplateService {

    public void sendMessage(javax.jms.Destination destination,String message);

}
