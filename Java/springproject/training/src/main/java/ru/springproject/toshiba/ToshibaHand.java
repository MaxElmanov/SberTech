package ru.springproject.toshiba;

import org.springframework.stereotype.Component;
import ru.springproject.interfaces.Hand;

public class ToshibaHand implements Hand {
    @Override
    public void take() {
        System.out.println("toshiba hand is taking");
    }
}
