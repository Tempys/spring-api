package com.dubovskyi.webflux.test;


import com.dubovskyi.webflux.SimpleApplication;
import com.dubovskyi.webflux.service.impl.BeanForPrototypeBeanTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SimpleApplication.class)
public class PrototypeTest {


    @Autowired
    BeanForPrototypeBeanTest beanRandom;


  @Test
  public void prototypeTest(){
      double result1 = beanRandom.returnRandomData();
      double result2 = beanRandom.returnRandomData();
      System.out.println(result1);
      System.out.println(result2);
      Assert.assertNotEquals(result1,result2,0);

  }


}
