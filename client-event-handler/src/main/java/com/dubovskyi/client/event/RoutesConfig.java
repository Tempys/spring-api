package com.dubovskyi.client.event;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.UUID;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RoutesConfig {

    @Bean
    public RouterFunction routes(){
        HandlerFunction hello = request -> ServerResponse.ok().body(fromObject(UUID.randomUUID().toString()));
        return route(GET("/"), hello);
    }
}
