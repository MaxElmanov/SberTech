package com.cursach.live;

import javax.swing.*;

public class Main extends JFrame {

    public Main() {
        setTitle("Cells");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(475, 490);
        setLocation(500, 500);
        add(new GameFiled(this));
        setVisible(true);
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}
