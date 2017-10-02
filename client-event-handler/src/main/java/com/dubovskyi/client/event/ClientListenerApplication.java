package com.dubovskyi.client.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication

public class ClientListenerApplication {



/*   static RouterFunction router = route(GET("/"), hello);*/







    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ClientListenerApplication.class, args);

     /*   HttpHandler httpHandler = RouterFunctions.toHttpHandler(router);*/

      /*  HttpServer
                .create("localhost", 8080)
                .newHandler(new ReactorHttpHandlerAdapter(httpHandler))
                .block();
*/
    }
}
