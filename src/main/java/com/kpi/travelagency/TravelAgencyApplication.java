package com.kpi.travelagency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TravelAgencyApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(TravelAgencyApplication.class, args);
    }
}
