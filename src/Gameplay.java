import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

//Note: Store all moves as [x,y]
//TODO paint method
//TODO expand mouseClicked with logic for recording two moves
//TODO expand mouseClicked with logic to compare moves
//TODO expand mouseClicked to update boards with new state
//TODO add to keyPressed to restart game


public class Gameplay extends JPanel implements ActionListener, KeyListener, MouseListener {
    int[] move1 = new int[2];
    int[] move2 = new int[2];
    BoardGenerator board;

    public Gameplay() {
        board = new BoardGenerator();
        addMouseListener(this);

    }

    public void paint(Graphics g) {
        //background

        //borders

        //Header with score

        //Tiles
        board.draw((Graphics2D)g);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        move1[0] = e.getX();
        move1[1] = e.getY();
        System.out.println(Arrays.toString(move1));

        repaint();


    }


//unused abstract methods
    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {}


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}