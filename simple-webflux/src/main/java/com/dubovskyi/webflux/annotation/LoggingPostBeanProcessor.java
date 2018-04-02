package com.dubovskyi.webflux.annotation;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

public class LoggingPostBeanProcessor implements BeanPostProcessor {


    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        Method[] methods = bean.getClass().getDeclaredMethods();


        for (Method method : methods) {
          Logging annotation =  method.getAnnotation(Logging.class);

          if (annotation != null){
              System.out.println("Oyeee its work...");
              System.out.println("method argument: "+ method.getParameters());
          }
        }

        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        return bean;
    }
}
