package org.changli.covermanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.changli.covermanager.mapper")
public class CovermanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovermanagerApplication.class, args);
	}

}
