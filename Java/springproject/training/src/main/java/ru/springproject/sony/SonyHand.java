package ru.springproject.sony;

import org.springframework.stereotype.Component;
import ru.springproject.interfaces.Hand;

@Component
public class SonyHand implements Hand {
    @Override
    public void take() {
        System.out.println("sony hand is taking");
    }
}
