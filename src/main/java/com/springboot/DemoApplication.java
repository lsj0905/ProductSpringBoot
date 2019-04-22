package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@EnableTransactionManagement
@SpringBootApplication
@RestController
public class DemoApplication {

	@RequestMapping("/index.do")
	String LoginCookie(HttpServletRequest request, HttpServletResponse response){

		Cookie[] cookies=request.getCookies();

		int count=0;

		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("count")){
					count+=Integer.parseInt(cookie.getValue())+1;
				}
			}
		}

		if(count>5){
			return "你已经登录过多次了,等会你再登录,别急!";
		}else{
			Cookie cookie=new Cookie("count",count+"");
			response.addCookie(cookie);
		}
		return "您好，现在已经登录了"+count+"次!";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
