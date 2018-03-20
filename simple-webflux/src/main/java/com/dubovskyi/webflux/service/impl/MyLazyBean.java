package com.dubovskyi.webflux.service.impl;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Lazy
public class MyLazyBean {

    @PostConstruct
    public void init () {
        System.out.println(getClass().getSimpleName() + " has been initialized");
    }

    public void doSomething () {
        System.out.println("inside lazy bean doSomething()");
    }

}
