package com.raphaelcoutu.lenapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class LenappApplication {

    public static void main(String[] args) {
        SpringApplication.run(LenappApplication.class, args);
    }

}
