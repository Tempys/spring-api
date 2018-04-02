package com.dubovskyi.webflux.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyEagerBean {

    @Autowired
    @Lazy
    private MyLazyBean myLazyBean;

    @PostConstruct
    public void init () {
        System.out.println(getClass().getSimpleName() + " has been initialized");

    }

    public void doSomethingWithLazyBean () {
        System.out.println("Using lazy bean");
        myLazyBean.doSomething();
    }
}
