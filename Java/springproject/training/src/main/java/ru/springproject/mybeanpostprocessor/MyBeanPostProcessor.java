package ru.springproject.mybeanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import ru.springproject.robot.RobotT1000;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeforeInitialization- "+bean);
//        if(bean instanceof RobotT1000){
//            ((RobotT1000) bean).dance();
//        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("AfterInitialization - "+bean);
        System.out.println();
        return bean;
    }
}
