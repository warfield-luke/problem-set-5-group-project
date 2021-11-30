import javax.swing.*;
import java.util.Arrays;

public class Main {
    public static final int WIDTH = 700;
    public static final int HEIGHT = 720;

    public static void main(String[] args) {
        JFrame obj = new JFrame();
        Gameplay gamePlay = new Gameplay();
        obj.setBounds(10, 10, WIDTH, HEIGHT);
        obj.setTitle("Test Your Memory!");
        obj.setResizable(false);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gamePlay);
        obj.setVisible(true);
    }
}
