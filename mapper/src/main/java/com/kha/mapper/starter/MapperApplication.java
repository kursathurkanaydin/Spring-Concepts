package com.kha.mapper.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.kha.mapper"})
@EnableJpaRepositories(basePackages = {"com.kha.mapper"})
@ComponentScan(basePackages = {"com.kha.mapper"})
@PropertySource(value = "classpath:myapp.properties")
public class MapperApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapperApplication.class, args);
    }

}
