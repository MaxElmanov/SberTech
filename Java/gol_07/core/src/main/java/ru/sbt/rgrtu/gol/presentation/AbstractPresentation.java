package ru.sbt.rgrtu.gol.presentation;

import ru.sbt.rgrtu.gol.game.Gol;

public class AbstractPresentation implements Presentation{

    private Gol gol;

    public AbstractPresentation(Gol gol) {
        this.gol = gol;
    }

    public void show(String symbol){
        StringBuilder out = new StringBuilder();
        out.append(String.format("===== %1$05d =====", gol.getGeneration())).append("\n");
        for (int y = 0; y < gol.getSizeY(); y++) {
            for (int x = 0; x < gol.getSizeX(); x++) {
                out.append(gol.getPoint(x,y) ? symbol : " ");
            }
            out.append("\n");
        }
        System.out.println(out);
    }

    @Override
    public void show() { }
}
