package ru.sbt.rgrtu.gol.presentation;

import ru.sbt.rgrtu.gol.game.Gol;

public class ColoredPresentation implements Presentation {

    private final Gol gol;

    public ColoredPresentation(Gol gol) {
        this.gol = gol;
    }

    @Override
    public void show() {
        StringBuilder out = new StringBuilder();
        out.append(String.format("===== %1$05d =====", gol.getGeneration())).append("\n");
        for (int y = 0; y < gol.getSizeY(); y++) {
            for (int x = 0; x < gol.getSizeX(); x++) {
                out.append(gol.getPoint(x,y)
                        ? "\033[42m" // Green background
                        : "\033[40m" // Black background
                ).append(" ");
            }
            out.append("\033[0m").append("\n"); // reset
        }
        System.out.println(out);
    }
}
