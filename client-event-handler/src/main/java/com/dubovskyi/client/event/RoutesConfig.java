package com.dubovskyi.client.event;

import com.dubovskyi.client.event.dto.*;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.function.Function;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RoutesConfig {

    @Bean
    public MapperFactory createMapperFactory(){
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        ConverterFactory converterFactory = mapperFactory.getConverterFactory();
        converterFactory.registerConverter("userConvector",new UserConvecter());


        return mapperFactory;
    }

    @Bean
    public RouterFunction routes(MapperFactory factory){
        HandlerFunction hello = request -> ServerResponse.ok().body(fromObject(UUID.randomUUID().toString()));

        Function<Personne,Person> transform = item -> {

                factory.classMap(Personne.class, Person.class)
                         .field("nom", "name")
                         .field("surnom", "nickname")
                          .field("details","details")
                         .fieldMap("user","isAdmin").converter("userConvector").mapNulls(true).mapNullsInReverse(true).add()
                         .byDefault()
                         .register();


               factory.classMap(DetailsDto.class, Details.class)
                       .field("street1","street")
                       .field("city1","city")
                       .byDefault()
                       .register();


            MapperFacade mapper = factory.getMapperFacade();
           // Personne frenchPerson = new Personne("Claire", "cla", 25);
            return  mapper.map(item, Person.class);

        };



        HandlerFunction notification = request -> request.bodyToMono(Personne.class)
                                                          .doOnNext(i -> System.out.println(i.getDetails()))
                                                         .map(transform).flatMap(response -> ServerResponse.ok().body(Mono.just(response),Person.class));

        return route(GET("/"), hello)
                .andRoute(POST("/notification"),notification) ;
    }
}
