package com.ljs;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.ljs.bean.MyBean;
import com.ljs.bean.ShaBean;

/**
 * @author ljs
 * @since 2021/8/25 下午8:26
 **/
public class BeanTJson {


    public static void main(String[] args) throws JsonProcessingException {
        ShaBean shaBean = new ShaBean();
        shaBean.setHA_S("sshs");
        shaBean.setUSER_NAME("weishao");
        shaBean.setLoveAnd("dppd");

        MyBean myBean = new MyBean();
        myBean.setAa("aaa");
        myBean.setBb("bbb");

        shaBean.setMY_BEAN(myBean);

        Gson gson = new Gson();
        String s = gson.toJson(shaBean);
        System.out.println(s);

        Object o = JSON.toJSON(shaBean);
        System.out.println(s);

        ObjectMapper mapper = new ObjectMapper();
       // mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
       // mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        mapper.setVisibilityChecker(mapper.getSerializationConfig().getDefaultVisibilityChecker()
                .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));



        String s1 = mapper.writeValueAsString(shaBean);

        System.out.println(s1);

        System.out.println(mapper.writeValueAsString(myBean));
    }

}
