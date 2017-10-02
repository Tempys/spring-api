package com.dubovskyi.webflux.service.impl;

import com.dubovskyi.webflux.service.BalanceService;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class GetBalanceMiddleWareBean {

    public int getBalance() {

        BalanceService randomService = getRandomService();

        return randomService.balanceGenerate();
    }


    @Lookup
    BalanceService getRandomService(){
        return  null;
    }
}


