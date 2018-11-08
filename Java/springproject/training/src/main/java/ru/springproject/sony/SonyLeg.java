package ru.springproject.sony;

import org.springframework.stereotype.Component;
import ru.springproject.interfaces.Leg;

@Component
public class SonyLeg implements Leg {
    @Override
    public void go() {
        System.out.println("sony legs are going");
    }
}
