package com.glovoapp.backender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.glovoapp.backender")
@EnableAutoConfiguration
public class API {

    public static void main(String[] args) {
        SpringApplication.run(API.class);
    }

}
