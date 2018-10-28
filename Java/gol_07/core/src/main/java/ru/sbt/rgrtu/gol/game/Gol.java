package ru.sbt.rgrtu.gol.game;

import ru.sbt.rgrtu.gol.boardfilling.Filling;
import ru.sbt.rgrtu.gol.config.Configuration;
import ru.sbt.rgrtu.gol.config.ConfigurationProvider;

import java.io.IOException;
import java.util.Random;

/**
 * Game of Life.
 * <p> 1. Any live cell with fewer than two live neighbors dies, as if by under population.
 * <p> 2. Any live cell with two or three live neighbors lives on to the next generation.
 * <p> 3. Any live cell with more than three live neighbors dies, as if by overpopulation.
 * <p> 4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 */
public class Gol {

    private final ConfigurationProvider configurationProvider;
    private final Filling fill;

    private int sizeX;
    private int sizeY;

    private boolean[][] current;
    private boolean[][] next;
    private long generation;

    private boolean[][] createGeneration() {
        return new boolean[sizeX][sizeY];
    }

    /**
     * Create an instance with settings from a given file.
     * @param configurationProvider provider of simulation settings
     */
    public Gol(ConfigurationProvider configurationProvider, Filling fill) {
        this.configurationProvider = configurationProvider;
        this.fill = fill;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    /** Number of current generation. */
    public long getGeneration() {
        return generation;
    }

    /**
     * Get current value of the point.
     * @param x abscissa
     * @param y ordinate
     * @return current value
     */
    public boolean getPoint(int x, int y) {
        return current[(sizeX + x) % sizeX][(sizeY + y) % sizeY];
    }

    public void init() throws IOException {
        Configuration configuration = configurationProvider.getConfiguration();
        this.sizeX = configuration.getSizeX();
        this.sizeY = configuration.getSizeY();

        current = createGeneration();
        next = createGeneration();

        current = fill.fillBoard(this.sizeX, this.sizeY);
    }

    public void nextStep() {
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                int neighbours = countNeighbours(x, y);
                next[x][y] = calculateNewValue(getPoint(x,y), neighbours);
            }
        }
        current = next;
        generation++;
        next = createGeneration();
    }

    private int countNeighbours(int x, int y) {
        int count = 0;
        for (int m = x-1; m <= x+1; m++) {
            for (int n = y-1; n <= y+1; n++) {
                if (m==x && n==y) continue;
                if (getPoint(m,n)) count++;
            }
        }
        return count;
    }

    private boolean calculateNewValue(boolean old, int n) {
        if (n == 3) return true; // rules 2 and 4
        return old && n == 2; // rules 1, 2 and 3
    }

}
