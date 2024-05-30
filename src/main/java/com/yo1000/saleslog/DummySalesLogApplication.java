package com.yo1000.saleslog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class DummySalesLogApplication {
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(DummySalesLogApplication.class, args);
		// Block the main thread
		new CountDownLatch(1).await();
	}
}
