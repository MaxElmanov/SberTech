package ru.springproject.sony;

import org.springframework.stereotype.Component;
import ru.springproject.interfaces.Head;


@Component
public class SonyHead implements Head {
    @Override
    public void think() {
        System.out.println("sony head is thinking");
    }
}
