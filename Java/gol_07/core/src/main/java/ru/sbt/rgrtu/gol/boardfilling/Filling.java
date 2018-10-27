package ru.sbt.rgrtu.gol.boardfilling;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface Filling {
    boolean[][] fillBoard(long seed, int sizeX, int sizeY) throws IOException;
}
