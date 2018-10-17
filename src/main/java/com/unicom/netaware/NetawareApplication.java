package com.unicom.netaware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.unicom"})
public class NetawareApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetawareApplication.class, args);
	}
}
