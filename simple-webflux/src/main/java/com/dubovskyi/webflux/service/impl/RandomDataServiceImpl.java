package com.dubovskyi.webflux.service.impl;


import com.dubovskyi.webflux.service.RandomService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Scope( value= BeanDefinition.SCOPE_PROTOTYPE, proxyMode= ScopedProxyMode.INTERFACES )
public class RandomDataServiceImpl implements RandomService {

    @Override
    public String getRandomUuid() {
        return UUID.randomUUID().toString();
    }
}
