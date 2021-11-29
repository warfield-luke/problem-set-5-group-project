import java.awt.*;
import java.util.Arrays;
import java.util.Random;


//Note: Store all moves as [x,y]
//TODO Draw method (luke)

//array check code
//        System.out.println(Arrays.toString(values[0]));
//        System.out.println(Arrays.toString(values[1]));
//        System.out.println(Arrays.toString(values[2]));
//        System.out.println(Arrays.toString(values[3]));
//        System.out.println("*************");

public class BoardGenerator {
    public int tileHeight;
    public int tileWidth;
    public static int[][] values = new int[4][4];
    public boolean[][] faceUp = new boolean[4][4];
    Random r = new Random();

    public BoardGenerator() {
        //fill array with values to match
        int tx, ty, temp;
        int n = 0;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                values[i][j] = n % 8 + 1;
                n++;
            }
        }

        //randomize positions
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    tx = r.nextInt(4);
                    ty = r.nextInt(4);

                    temp = values[j][k];
                    values[j][k] = values[ty][tx];
                    values[ty][tx] = temp;
                }
            }
        }

        //Set tile width and height
        tileHeight = (Main.HEIGHT - 100) / 4;
        tileWidth = (Main.WIDTH - 100) / 4;

    }

    public void draw(Graphics2D g) {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[0].length; j++) {
                if(values[i][j] > 0) {
                    g.setColor(Color.green);
                    //g.fillRect();

                }
            }
        }
    }

    public void match(int[] move1, int[] move2) {
        values[move1[1]][move1[0]] = 0;
        values[move2[1]][move2[0]] = 0;
    }

    public void setStateUp(int x, int y) {
        faceUp[y][x] = true;
    }
    public void setStateDown(int x, int y) {
        faceUp[y][x] = false;
    }


}
