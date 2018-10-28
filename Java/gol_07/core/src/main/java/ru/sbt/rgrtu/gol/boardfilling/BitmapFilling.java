package ru.sbt.rgrtu.gol.boardfilling;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class BitmapFilling implements Filling{

    @Override
    public boolean[][] fillBoard(int sizeX, int sizeY) throws IOException {
        byte[] imageInByte;
        boolean[][] current = new boolean[sizeX][sizeY];

        try{
            File originalImage = new File("bitmap.bmp");
            BufferedImage imgBuffer = ImageIO.read(originalImage);
            imageInByte = (byte[])imgBuffer.getRaster().getDataElements(0, 0, imgBuffer.getWidth(), imgBuffer.getHeight(), null);
            System.out.println(imageInByte.length);

            for (int k = 0; k < current.length; k++) {
                for (int p = 0; p < current[k].length; p++) {
                    current[k][p] = false;
                }
            }

            int i = 0,j = 0;
            for (int k = 0; k < imageInByte.length; k++) {
                if(j == imgBuffer.getWidth()) {
                    i++;
                    j = 0;
                }
                
                if (imageInByte[k] == 0) {  //r == black
                    current[i][j] = true;
                }
                j++;
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }

        return current;
    }
}
