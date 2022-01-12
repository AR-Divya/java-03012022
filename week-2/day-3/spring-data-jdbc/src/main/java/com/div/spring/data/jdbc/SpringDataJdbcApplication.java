package com.div.spring.data.jdbc;

import com.div.spring.data.jdbc.service.DbService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDataJdbcApplication {
	public static void main(String[] args) {

		SpringApplication.run(SpringDataJdbcApplication.class, args);

//		ApplicationContext ctx = SpringApplication.run(SpringDataJdbcApplication.class, args);
//		DbService service = ctx.getBean(DbService.class);
//		service.saveCar();
	}
}