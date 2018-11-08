package ru.springproject.toshiba;

import org.springframework.stereotype.Component;
import ru.springproject.interfaces.Leg;

public class ToshibaLeg implements Leg {
    @Override
    public void go() {
        System.out.println("toshiba legs are going");
    }
}
