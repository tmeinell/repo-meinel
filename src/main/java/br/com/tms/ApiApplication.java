package br.com.tms;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
    
    @Bean
    public CommandLineRunner CommandLineRunner(){
        return args -> {
            System.out.println("###################################################");
            System.out.println("Aplication is running....");
            System.out.println("###################################################");            
        };
    }
}
