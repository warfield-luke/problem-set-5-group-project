import java.awt.*;
import java.util.Random;


public class BoardGenerator {
    public static int tileHeight;
    public static int tileWidth;
    private static int[][] values = new int[4][4];
    private static boolean[][] faceUp = new boolean[4][4];
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
        tileHeight = (Main.HEIGHT - 170) / 4;
        tileWidth = (Main.WIDTH - 100) / 4;

    }

    public void draw(Graphics2D g) {
        Color tileColor = new Color(103, 10, 10);
        Font outputFont = new Font("Gothic", Font.ITALIC, 40);
        //draw tiles on JFrame
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[0].length; j++) {
                if(values[i][j] != 0 && !faceUp[i][j]) {
                    //draw face down tiles
                    g.setColor(tileColor);
                    g.fillRect((20 + (j * (tileWidth + 20))), (70 + (i * (tileHeight+ 20))), tileWidth, tileHeight);
                }
                if(values[i][j] != 0 && faceUp[i][j]) {
                    //draw face up tiles
                    g.setColor(tileColor);
                    g.fillRect((20 + (j * (tileWidth + 20))), (70 + (i * (tileHeight+ 20))), tileWidth, tileHeight);

                    g.setColor(Color.white); //setting colors of number values
                    g.setFont(outputFont); //change the font and size of letters
                    g.drawString("" + values[i][j], 5 + (tileWidth/2) + (j * (tileWidth + 20)), 85 + (tileHeight/2) + (i * (tileHeight + 20))); //place the position of the board

                }
            }
        }
    }

    public static boolean testMatch(int[] move1, int[] move2) {
        return BoardGenerator.values[move1[1]][move1[0]] == BoardGenerator.values[move2[1]][move2[0]];
    }

    public static void match(int[] move1, int[] move2) {
        //sets values to not display given cards
        values[move1[1]][move1[0]] = 0;
        values[move2[1]][move2[0]] = 0;
    }

    public static void setStateUp(int[] move) {
        faceUp[move[1]][move[0]] = true;
    }
    public static void setStatesDown(int[] move1, int[] move2) {
        faceUp[move1[1]][move1[0]] = false;
        faceUp[move2[1]][move2[0]] = false;
    }


}
