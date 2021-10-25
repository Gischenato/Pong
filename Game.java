import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{

    public static final int WIDHT = 240;
    public static final int HEIGHT = 280;
    public static final int SCALE = 3;

    public Game(){
        this.setPreferredSize(new Dimension(WIDHT*SCALE ,HEIGHT*SCALE));
    }

    public static void main(String[] args) {
        Game game = new Game();

        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void run(){

    }
}