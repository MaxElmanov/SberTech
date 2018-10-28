package ru.sbt.rgrtu.gol.boardfilling;

import java.util.Random;

public class RandomFilling implements Filling {
    private long seed;

    public RandomFilling(long seed) {
        this.seed = seed;
    }

    @Override
    public boolean[][] fillBoard(int sizeX, int sizeY) {
        boolean[][] current = new boolean[sizeX][sizeY];
        Random random = new Random(seed);

        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                current[x][y] = random.nextBoolean();
            }
        }

        return current;
    }
}
