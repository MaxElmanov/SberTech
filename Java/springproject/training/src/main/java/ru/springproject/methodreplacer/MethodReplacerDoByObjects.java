package ru.springproject.methodreplacer;

import java.lang.reflect.Method;
import org.springframework.beans.factory.support.MethodReplacer;

public class MethodReplacerDoByObjects implements MethodReplacer{
    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("MethodReplacerDoByObjects - new action!!!");
        return null;
    }
}
