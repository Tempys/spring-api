package com.dubovskyi.webflux.config;


import com.dubovskyi.webflux.annotation.LoggingPostBeanProcessor;
import com.dubovskyi.webflux.annotation.ProfilingPostBeanProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class PostProcessorsConfig {

    @Bean
    public LoggingPostBeanProcessor createLoggingPostBeanProcessor(){
        return new LoggingPostBeanProcessor();
    }

    @Bean
    public ProfilingPostBeanProcessor createProfilingPostBeanProcessor(){
        return new ProfilingPostBeanProcessor();
    }

}
