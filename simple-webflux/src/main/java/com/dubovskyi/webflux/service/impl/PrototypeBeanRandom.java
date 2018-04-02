package com.dubovskyi.webflux.service.impl;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class PrototypeBeanRandom {

    private final double data ;

    public PrototypeBeanRandom() {
        this.data =  Math.random() ;
    }

    public  double returnRandomData(){
        return  data;
    }
}
