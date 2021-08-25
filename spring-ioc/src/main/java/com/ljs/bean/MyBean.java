package com.ljs.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;


@Data
@NoArgsConstructor
public class MyBean implements InstantiationAwareBeanPostProcessor {

    @JsonProperty(value = "AA")
    private String aa;

    @JsonProperty(value = "Bb")
    private String bb;

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return false;
    }
}
