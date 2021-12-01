import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

//Write your name next to the to-dos to claim them
//TODO expand mouseClicked with logic for recording two moves (luke)
//TODO expand mouseClicked with logic to compare moves
//TODO expand mouseClicked to update boards with new state
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
            move1[0] = e.getX();
            move1[1] = e.getY();

            //convert pixel coords to array cords for tiles
            move1[0] = (move1[0] - 20) ; //divide by width and subtract bound
            move1[1] = (move1[1] - 70) ;

            System.out.println(Arrays.toString(move1));
            System.out.println(Arrays.toString(move2));
            moveCount++;
        } else if (moveCount == 1) {
            move2[0] = e.getX();
            move2[1] = e.getY();
            System.out.println(Arrays.toString(move1));
            System.out.println(Arrays.toString(move2));
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