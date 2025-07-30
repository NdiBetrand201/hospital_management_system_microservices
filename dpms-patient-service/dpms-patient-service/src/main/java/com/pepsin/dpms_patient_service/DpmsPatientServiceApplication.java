package com.pepsin.dpms_patient_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DpmsPatientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DpmsPatientServiceApplication.class, args);
	}

}
