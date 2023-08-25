package com.example.demo.jsonplaceholder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JSONPlaceHolderConfiguration {
    @Bean("jsonplaceholder")
    CommandLineRunner runner(JSONPlaceHolderClient placeHolderClient) {
        return args -> {
            System.out.println(placeHolderClient.getPosts().size());
            System.out.println(placeHolderClient.getPost(1));
        };
    }
}
