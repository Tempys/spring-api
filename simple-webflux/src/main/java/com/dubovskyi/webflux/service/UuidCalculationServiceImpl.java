package com.dubovskyi.webflux.service;

import com.dubovskyi.webflux.annotation.Profiling;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UuidCalculationServiceImpl implements UuidCalculateService {

    @Profiling
    public String calculates(){
        return UUID.randomUUID().toString();
    }
}
