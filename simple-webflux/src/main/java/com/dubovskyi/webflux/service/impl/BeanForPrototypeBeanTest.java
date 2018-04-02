package com.dubovskyi.webflux.service.impl;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

@Service
public class BeanForPrototypeBeanTest {

    @Lookup
    public PrototypeBeanRandom getPrototypeBeanRandom(){
        return null;
    }


    public double returnRandomData(){

     return    getPrototypeBeanRandom().returnRandomData();
    }

}
