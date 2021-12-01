import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

//Write your name next to the to-dos to claim them
//TODO expand mouseClicked to update boards with new state (faceUp)
//TODO add to keyPressed to restart game (mostly done, verify all pertinent vars are reset)


public class Gameplay extends JPanel implements ActionListener, KeyListener, MouseListener {
    int[] move1 = new int[2];
    int[] move2 = new int[2];
    BoardGenerator board;
    int score = 0;
    int moveCount = 0;

    public Gameplay() {
        board = new BoardGenerator();
        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);

    }

    public void paint(Graphics g) {
        Color backColor = new Color(53, 101, 77);
        //background
        g.setColor(backColor);
        g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);

        //Header with score
        g.setColor(Color.white);
        g.drawString("Score: " + score, 327, 35);

        //Tiles
        board.draw((Graphics2D)g);
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_Y) {
            score = 0;
            BoardGenerator board = new BoardGenerator();
        }
        if(e.getKeyCode() == KeyEvent.VK_N) {
            System.exit(0);
        }
        repaint();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (moveCount == 0) {
            //get coords for move1
            move1[0] = e.getX();
            move1[1] = e.getY();

            //convert pixel coords to array cords for tiles
            move1[0] = (move1[0] - 20) / (BoardGenerator.tileWidth + 20);
            move1[1] = (move1[1] - 70) / (BoardGenerator.tileHeight + 20);

            System.out.println(Arrays.toString(move1));
            System.out.println(Arrays.toString(move2));
            moveCount++;

        } else if (moveCount == 1) {
            //get coords for move2
            while(true) {
                move2[0] = e.getX();
                move2[1] = e.getY();

                //convert pixel coords to array cords for tiles
                move2[0] = (move2[0] - 20) / (BoardGenerator.tileWidth + 20);
                move2[1] = (move2[1] - 70) / (BoardGenerator.tileHeight + 20);

                System.out.println(Arrays.toString(move1));
                System.out.println(Arrays.toString(move2));

                if(!Arrays.equals(move1, move2)) {
                    System.out.println("avocado");
                    if (BoardGenerator.values[move1[1]][move1[0]] == BoardGenerator.values[move2[1]][move2[0]]) {
                        BoardGenerator.match(move1, move2);
                        break;
                }
            }
        }

        moveCount--;
        }

        repaint();

    }


//unused abstract methods
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void actionPerformed(ActionEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}