import java.util.Arrays;


//Note: Store all moves as [x,y]
//TODO Randomize positions of values within array (Better as 1D than 2D for this?)
//TODO Draw method

//array check code
//        System.out.println(Arrays.toString(values[0]));
//        System.out.println(Arrays.toString(values[1]));
//        System.out.println(Arrays.toString(values[2]));
//        System.out.println(Arrays.toString(values[3]));

public class BoardGenerator {
    public int tileHeight;
    public int tileWidth;
    public static int[][] values = new int[4][4];
    public boolean[][] faceUp = new boolean[4][4];

    public BoardGenerator() {
        //fill array with values to match
        int n = 0;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                values[i][j] = n % 8 + 1;
                n++;
            }
        }
        //randomize positions

        //Set tile width and height



    }

    public void draw() {}

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
