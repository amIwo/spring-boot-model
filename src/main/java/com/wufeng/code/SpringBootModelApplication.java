package com.wufeng.code;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.wufeng.code.dao.mapper")
public class SpringBootModelApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootModelApplication.class, args);
	}

}
