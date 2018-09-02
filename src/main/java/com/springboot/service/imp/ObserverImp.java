package com.springboot.service.imp;

import com.springboot.service.Observer;

public class ObserverImp implements Observer {

    private String name;

    public ObserverImp(String name){
        this.name=name;
    }



    @Override
    public void update(String message) {

        System.out.println(message+":"+name);

        if(name.equals("李玲玲1")){
            System.out.println("就你了"+name+"赶紧别监视我了，走开！！！");
        }
    }
}
