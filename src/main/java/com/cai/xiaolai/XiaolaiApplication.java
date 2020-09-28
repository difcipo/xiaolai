package com.cai.xiaolai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cai.xiaolai.mapper")
public class XiaolaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(XiaolaiApplication.class, args);
	}

}
