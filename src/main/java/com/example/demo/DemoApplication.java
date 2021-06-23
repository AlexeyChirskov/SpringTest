package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	@SessionScope
	public Map<String, String> mapObject1() {
		Map<String, String> obj = new HashMap<>();
		obj.put("key", "okay 3.14");
		obj.put("key1", "Arrays.asList(a,b,c)");
		return obj;
	}

	@Bean
	@RequestScope
	public Map<String, String> mapObject2() {
		Map<String, String> obj = new HashMap<>();
		obj.put("key", "okay 3.14");
		obj.put("key1", "Arrays.asList(a,b,c)");
		return obj;
	}

	@Bean
	public Map<String, String> mapObject3() {
		Map<String, String> obj = new HashMap<>();
		obj.put("key", "okay 3.14");
		obj.put("key1", "Arrays.asList(a,b,c)");
		return obj;
	}

}
