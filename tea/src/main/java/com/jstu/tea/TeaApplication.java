package com.jstu.tea;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jstu.tea.dao")
public class TeaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeaApplication.class, args);
	}
}
