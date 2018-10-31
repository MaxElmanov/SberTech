package ru.sbt.rgrtu.gol.boardfilling;

import java.io.*;
import java.util.Scanner;

public class TxtFilling implements Filling {
    private final char aliveSymbol = '*';
    private final char deadSymbol = ' ';
    private String file;

    public TxtFilling(String file) {
        this.file = file;
    }

    @Override
    public boolean[][] fillBoard(int sizeX, int sizeY) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(file)));
        boolean[][] current = new boolean[sizeX][sizeY];

        //Scanner scanner = new Scanner(file);

        for (int k = 0; k < current.length; k++) {
            for (int p = 0; p < current[k].length; p++) {
                current[k][p] = false;
            }
        }

        String line;
        int k=0;
        while((line = bufferedReader.readLine()) != null) {

            for (int p = 0; p < line.length(); p++) {
//                System.out.println(p);
                if (line.charAt(p) == aliveSymbol){
                    current[k][p] = true;
                }
            }
            k++;
        }

//        for (int k = 0; scanner.hasNextLine(); k++) {
//            String line = scanner.nextLine();
//            for (int p = 0; p < line.length(); p++) {
//                if (line.charAt(p) == aliveSymbol){
//                    current[k][p] = true;
//                }
//            }
//        }
//
//        scanner.close();

        bufferedReader.close();

        return current;
    }
}
