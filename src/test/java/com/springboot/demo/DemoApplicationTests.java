package com.springboot.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@RequestMapping("/index.do")
	String test(){


		return "你好吗？";
	}

	@Test
	public void contextLoads() {
	}

}
