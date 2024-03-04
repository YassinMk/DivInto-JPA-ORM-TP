package org.example.divintojpaormhospitalapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DivIntoJpaOrmHospitalAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(DivIntoJpaOrmHospitalAppApplication.class, args);
    }
    @Bean //notation to make the method a bean in the spring container
    CommandLineRunner start(){
        return args -> {

        };
    }

}
