package ru.springproject.toshiba;

import org.springframework.stereotype.Component;
import ru.springproject.interfaces.Head;

public class ToshibaHead implements Head {
    @Override
    public void think() {
        System.out.println("toshiba head is thinking");
    }
}
