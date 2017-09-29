package com.dubovskyi.webflux;


import com.dubovskyi.webflux.service.UuidCalculateService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SimpleApplication {

    public static void main(String[] args) {
      ApplicationContext context = SpringApplication.run(SimpleApplication.class, args);
        UuidCalculateService uuidCalculateService = context.getBean(UuidCalculateService.class);
        uuidCalculateService.calculates();


    }
}
