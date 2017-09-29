package com.dubovskyi.webflux.annotation;

import com.dubovskyi.webflux.annotation.Profiling;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ProfilingPostBeanProcessor implements BeanPostProcessor {

    private Map<String,Class> beanClassMap = new HashMap<>();



    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Method[] methods = bean.getClass().getMethods();
        for (Method method : methods) {
            Profiling profiling = method.getAnnotation(Profiling.class);

            if (profiling != null) {
                beanClassMap.put(beanName, bean.getClass());
            }
        }


        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {


            if(beanClassMap.containsKey(beanName)){

            System.out.println("start process profiling: " + bean.getClass().toString());
            System.out.println("interfaces: "+ bean.getClass().getInterfaces().length);
                System.out.println("annotations: "+bean.getClass().getAnnotations().length);




            return Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                    Profiling annotation =  method.getDeclaredAnnotation(Profiling.class);
                    System.out.println("method: "+ method.toString() +"  anotation: "+annotation);
                    System.out.println(method.getAnnotations().length);
                    Object ret =  null;
                    if (bean.getClass().getMethod(method.getName(), method.getParameterTypes()).getAnnotation(Profiling.class) != null){
                        long start = System.currentTimeMillis();
                        ret = method.invoke(bean,args);
                        long stop = System.currentTimeMillis();

                        System.out.println("calculation: time: " + ((stop-start)));
                    } else {

                        ret = method.invoke(bean,args);
                    }

                    return ret;
                }
            });
        }

        return bean;
    }
}
