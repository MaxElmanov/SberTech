package ru.sbt.rgrtu.gol.config;

/**
 * Game settings
 */
public class Configuration {

    /** Horizontal size of the board. */
    private int sizeX;
    /** Vertical size of the board. */
    private int sizeY;

    /** Seed for random board initialization. */
    private long seed;

    private int speed;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public long getSeed() {
        return seed;
    }

    public void setSeed(long seed) {
        this.seed = seed;
    }
}
