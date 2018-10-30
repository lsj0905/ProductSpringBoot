package com.springboot.demo.Collection;

import com.springboot.model.User;

import java.util.HashMap;

public class testMap {

    public static void main(String[] args) {

        HashMap<String,String> hashMap=new HashMap<String,String>();

        hashMap.put(null,"可以空吗？");

        String s="sdfdf";

        String s2=s.intern();

        System.out.println("intern"+s2);

        User user=new User();

        User user1=new User();

        String s1="sdfdf";

        System.out.println(user.equals(user1));
        System.out.println(hashMap.get(null));
    }

}
