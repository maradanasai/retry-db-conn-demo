package com.example.retrydbconndemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class RetryDbConnDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetryDbConnDemoApplication.class, args);
	}

}
