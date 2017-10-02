package com.dubovskyi.webflux.service.impl;



import com.dubovskyi.webflux.service.BalanceService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Scope("prototype")
public class BalanceServiceImpl implements BalanceService {

    private  int balance;

    public BalanceServiceImpl() {
        Random random = new Random();
        this.balance =  1 + random.nextInt((100- 1) + 1);
    }

    @Override
    public int balanceGenerate() {
       return balance;
    }
}
