import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;


public class Gameplay extends JPanel implements ActionListener, KeyListener, MouseListener {
    int[] move1 = new int[2];
    int[] move2 = new int[2];
    BoardGenerator board;
    int score = 0;
    int moveCount = 0;
    boolean delaying = false;
    private Timer delayTimer;

    public Gameplay() {
        board = new BoardGenerator();
        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);

        //Timer to allow player time to see tile values
        delayTimer = new Timer(1200, evt -> {

            repaint();
            if (BoardGenerator.testMatch(move1, move2)) {
                BoardGenerator.match(move1, move2);
                score += 10;
            } else {
                BoardGenerator.setStatesDown(move1, move2);
            }
            clearMoves();
            delaying = false;

        });
        delayTimer.setRepeats(false);

    }

    public void paint(Graphics g) {
        Color backColor = new Color(53, 101, 77);
        //background
        g.setColor(backColor);
        g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);

        //Header with score
        g.setColor(Color.white);
        g.setFont(new Font("Gothic", Font.ITALIC, 40));
        g.drawString("Score: " + score, 270, 40);

        //Tiles
        board.draw((Graphics2D)g);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //allows restart/close of game
        if(e.getKeyCode() == KeyEvent.VK_Y) {
            score = 0;
            clearMoves();
            BoardGenerator board = new BoardGenerator();
        }
        if(e.getKeyCode() == KeyEvent.VK_N) {
            System.exit(0);
        }
        repaint();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!delaying) {
            if (moveCount == 0) {
                getClick(move1, e);
                BoardGenerator.setStateUp(move1);
                moveCount++;

            } else if (moveCount == 1) {
                getClick(move2, e);

                //Verify move is unique from move1
                if (!Arrays.equals(move1, move2)) {
                    BoardGenerator.setStateUp(move2);
                    moveCount--;

                    //showing player the tile values
                    delaying = true;
                    delayTimer.start();
                }

            }

            repaint();

        }
    }

    public static void getClick(int[] move, MouseEvent e) {
        //Get coords of click
        move[0] = e.getX();
        move[1] = e.getY();

        //Prints coords of move: System.out.println(Arrays.toString(move));

        //convert pixel coords to array cords for tiles
        move[0] = (move[0] - 20) / (BoardGenerator.tileWidth + 20);
        move[1] = (move[1] - 70) / (BoardGenerator.tileHeight + 20);

    }

    public void clearMoves() {
        move1 = new int[2];
        move2 = new int[2];
    }



//unused abstract methods
    @Override
    public void actionPerformed(ActionEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}