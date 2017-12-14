package com.zhouqi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.MappedSuperclass;

/**
 * @author zhouqi on 2017/12/1.
 */
@SpringBootApplication
@MapperScan(basePackages = "com.zhouqi.dataobject.mapper")
public class SellApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellApplication.class, args);
	}
}
