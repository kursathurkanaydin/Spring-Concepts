package com.kha.studentdemo.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.kha.studentdemo"})
@EntityScan(basePackages = {"com.kha.studentdemo"})
@EnableJpaRepositories(basePackages = {"com.kha.studentdemo"})
public class StudentDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentDemoApplication.class, args);
    }

}
