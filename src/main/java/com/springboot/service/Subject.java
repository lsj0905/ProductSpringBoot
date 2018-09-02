package com.springboot.service;

public interface Subject {

    public void attach(Observer observer);

    public void detach(Observer observer);

    public void notify(String message);

}
