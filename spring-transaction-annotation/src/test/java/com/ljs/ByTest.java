package com.ljs;


import com.ljs.service.SaleGoodService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * create by ljs on 2020/6/17 7:25
 * <p>
 * description:
 */


public class ByTest {


    private ClassPathXmlApplicationContext context;

    @Before
    public void init(){
        String config = "applicationContext.xml";
        context = new ClassPathXmlApplicationContext(config);
    }

    @Test
    public void allBeanInIOC(){

        String[] definitionNames = context.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }


    @Test
    public void buySome(){

        SaleGoodService goodService = (SaleGoodService) context.getBean("saleGoodService");
        goodService.SaleGood(1002, 12);

    }

}
