package com.dubovskyi.webflux;


import com.dubovskyi.webflux.service.UuidCalculateService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SimpleApplication {

    public static void main(String[] args) {
      ApplicationContext context = SpringApplication.run(SimpleApplication.class, args);


       /* UuidCalculateService uuidCalculateService = context.getBean(UuidCalculateService.class);

        for(int i=0;i<=3;i++){
            System.out.println("UUID: " + uuidCalculateService.calculates());
        }*/

       UuidCalculateService uuidCalculateService = context.getBean(UuidCalculateService.class);

        for(int i=0;i<=3;i++){
            System.out.println("Balance: " + uuidCalculateService.getBalance());
        }

    }
}
