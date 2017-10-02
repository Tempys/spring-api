package com.dubovskyi.webflux.service.impl;

import com.dubovskyi.webflux.annotation.Profiling;
import com.dubovskyi.webflux.service.RandomService;
import com.dubovskyi.webflux.service.UuidCalculateService;
import org.springframework.stereotype.Service;

@Service
public class UuidCalculationServiceImpl implements UuidCalculateService {

    private final RandomService randomService;
    private final GetBalanceMiddleWareBean getBalanceMiddleWareBean;

    public UuidCalculationServiceImpl(RandomService randomService, GetBalanceMiddleWareBean getBalanceMiddleWareBean) {
        this.randomService = randomService;
        this.getBalanceMiddleWareBean = getBalanceMiddleWareBean;
    }

    @Profiling
    public String calculates(){
        return randomService.getRandomUuid();
    }

    @Override
    public int getBalance() {
      return getBalanceMiddleWareBean.getBalance();
    }




}
