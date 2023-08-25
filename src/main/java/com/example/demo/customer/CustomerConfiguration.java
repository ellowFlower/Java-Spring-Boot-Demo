package com.example.demo.customer;

import com.example.demo.infoapp.InfoApp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfiguration {

    @Value("${app.useFakeRepo:false}")
    private Boolean useFakeRepo;

    @Bean
    CommandLineRunner runner(InfoApp infoApp) {
        return args -> {
            System.out.println(infoApp);
        };
    }

    @Bean
    CustomerRepo customerRepo() {
        System.out.println("useFakeRepo=" + useFakeRepo);
        return new CustomerFakeRepository();
    }
}
