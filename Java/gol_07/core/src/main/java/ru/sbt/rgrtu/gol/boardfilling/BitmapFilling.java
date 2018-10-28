package ru.sbt.rgrtu.gol.boardfilling;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class BitmapFilling implements Filling{

    private String file;

    public BitmapFilling(String file) {
        this.file= file;
    }

    @Override
    public boolean[][] fillBoard(int sizeX, int sizeY) throws IOException {
        byte[] imageInByte;
        boolean[][] current = new boolean[sizeX][sizeY];

        try{
            FileInputStream fis = new FileInputStream(String.valueOf(getClass().getClassLoader().getResource(file)));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int reads;
            while((reads = fis.read()) != -1) {
                baos.write(reads);
            }
            imageInByte = baos.toByteArray();

            // these two rows are nesseccury for imageInByte.length; (47)
            File originalImage = new File(String.valueOf(getClass().getClassLoader().getResource(file)));
            BufferedImage imgBuffer = ImageIO.read(originalImage);
//            imageInByte = (byte[])imgBuffer.getRaster().getDataElements(0, 0, imgBuffer.getWidth(), imgBuffer.getHeight(), null);

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
