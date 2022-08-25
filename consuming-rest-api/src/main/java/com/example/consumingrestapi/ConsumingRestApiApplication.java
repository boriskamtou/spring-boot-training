package com.example.consumingrestapi;

import com.example.consumingrestapi.entity.ListApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumingRestApiApplication {

    private static final Logger log = LoggerFactory.getLogger(ConsumingRestApiApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(ConsumingRestApiApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            ListApi listApi = restTemplate.getForObject("https://api.publicapis.org/entries", ListApi.class);

            log.info(listApi.getEntries().get(0).getAPI());
        };

    }
}
