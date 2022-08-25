package com.boris.dogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class DogsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DogsApplication.class, args);
    }

}
