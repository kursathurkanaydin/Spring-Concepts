package com.kha.exception.starter;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@PropertySource(value = "classpath:myapp.properties")
@EntityScan(basePackages = {"com.kha.exception"})
@ComponentScan(basePackages = {"com.kha.exception"})
@EnableJpaRepositories(basePackages = {"com.kha.exception"})
public class ExceptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExceptionApplication.class, args);
    }

}
