package com.pepsin.dpms_doctor_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DpmsDoctorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DpmsDoctorServiceApplication.class, args);
	}

}
