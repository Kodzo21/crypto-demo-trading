package com.example.springfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringFsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringFsApplication.class, args);
    }

}
