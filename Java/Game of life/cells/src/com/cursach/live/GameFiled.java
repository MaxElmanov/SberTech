package com.cursach.live;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFiled extends JPanel implements ActionListener{
    private Main main;
    private Timer timer;
    private Cell[][] cells;
    private Cell[][] tempCells;
    private final int DOT_SIZE = 15;
    private int countGeneration = 0;

    public GameFiled(Main main) {
        this.main = main;
        setBackground(Color.DARK_GRAY);
        initGame();
    }
    
    public void initGame(){
        cells = new Cell[30][30];
        tempCells = new Cell[30][30];
        initCells();
        timer = new Timer(50, this);
        timer.start();
    }

    private void initCells() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell();
                tempCells[i][j] = new Cell();
            }
        }
        cells[9][2].setAlive(true);
        cells[10][3].setAlive(true);
        cells[11][1].setAlive(true);
        cells[11][2].setAlive(true);
        cells[11][3].setAlive(true);

        tempCells[9][2].setAlive(true);
        tempCells[10][3].setAlive(true);
        tempCells[11][1].setAlive(true);
        tempCells[11][2].setAlive(true);
        tempCells[11][3].setAlive(true);

//        cells[13][12].setAlive(true);
//        cells[13][10].setAlive(true);
//        cells[12][10].setAlive(true);
//        cells[11][11].setAlive(true);
//        cells[10][12].setAlive(true);
//
//        tempCells[13][12].setAlive(true);
//        tempCells[13][10].setAlive(true);
//        tempCells[12][10].setAlive(true);
//        tempCells[11][11].setAlive(true);
//        tempCells[10][12].setAlive(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j].isAlive()) {
                    g.setColor(Color.green);
                    g.fillRect(j * DOT_SIZE, i * DOT_SIZE, DOT_SIZE, DOT_SIZE);
                }
                else{
                    g.setColor(Color.darkGray);
                    g.fillRect(j * DOT_SIZE, i * DOT_SIZE, DOT_SIZE, DOT_SIZE);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        main.setTitle("Cells: generation = " + countGeneration);

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j].isAlive()) {
                    aliveMethod(i, j);
                } else {
                    deadMethod(i, j);
                }
            }
        }

        countGeneration++;

        resetCells();

        repaint();
    }

    private void resetCells() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j].setAlive(tempCells[i][j].isAlive());
            }
        }
    }

    private void aliveMethod(int row, int col) {
        int counterAlive = countAliveCells(row, col);

        if(counterAlive == 2 || counterAlive == 3){
            row = BoderRow(row);
            col = BoderCol(col);
            tempCells[row][col].setAlive(true);
        }
        else if(counterAlive > 3 || counterAlive < 2){
            tempCells[row][col].setAlive(false);
        }
    }

    private void deadMethod(int row, int col) {
        int counterAlive = countAliveCells(row, col );

        if(counterAlive == 3){
            row = BoderRow(row);
            col = BoderCol(col);
            tempCells[row][col].setAlive(true);
        }
    }

    private int countAliveCells(int row, int col){
        int tempCounterAlive = 0,
            tempI = 0,
            tempJ = 0;

        for (int i = row-1; i < ((row-1)+3); i++) {
            for (int j = col-1; j < ((col-1)+3); j++) {
                if (i != row || j != col) {
                    tempI = BoderRow(i);
                    tempJ = BoderCol(j);
                    if (cells[tempI][tempJ].isAlive()) {
                        tempCounterAlive++;
                    }
                }
            }
        }

        return tempCounterAlive;
    }

    private int BoderRow(int row){
        if (row < 0){
            row = 29;
        } else if (row > 29){
            row = 0;
        }
        return row;
    }

    private int BoderCol(int col){
        if (col < 0){
            col = 29;
        } else if (col > 29){
            col = 0;
        }
        return col;
    }
}

