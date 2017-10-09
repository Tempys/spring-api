package com.dubovskyi.client.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication

public class ClientListenerApplication {


    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ClientListenerApplication.class, args);


    }
}
