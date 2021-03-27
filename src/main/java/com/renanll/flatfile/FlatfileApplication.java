package com.renanll.flatfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FlatfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlatfileApplication.class, args);
	}
}
