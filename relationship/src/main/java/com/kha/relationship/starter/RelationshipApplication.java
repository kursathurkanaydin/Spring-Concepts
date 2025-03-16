package com.kha.relationship.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.kha.relationship"})
@ComponentScan(basePackages = {"com.kha.relationship"})
@EntityScan({"com.kha.relationship"})
public class RelationshipApplication {


    public static void main(String[] args) {
        SpringApplication.run(RelationshipApplication.class, args);
    }

}
