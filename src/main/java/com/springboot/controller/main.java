package com.springboot.controller;

import com.springboot.service.Observer;
import com.springboot.service.Subject;
import com.springboot.service.imp.ObserverImp;
import com.springboot.service.imp.SubscriptionSubject;

public class main {
    public static void main(String[] args) {

        SubscriptionSubject subscriptionSubject=new SubscriptionSubject();

        Observer observer=new ObserverImp("李玲玲1是");

        Observer observer1=new ObserverImp("李玲玲2");
        Observer observer2=new ObserverImp("李玲玲3");

        subscriptionSubject.attach(observer);
        subscriptionSubject.attach(observer1);
        subscriptionSubject.attach(observer2);

        subscriptionSubject.notify("开始吧，总监视我，ss看看是谁");
    }
}
