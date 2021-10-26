import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener{

    public static final int WIDHT = 240;
    public static final int HEIGHT = 280;
    public static final int SCALE = 3;

    public BufferedImage layer;

    public Player player;
    public Enemy enemy;

    public Game(){
        this.setPreferredSize(new Dimension(WIDHT*SCALE ,HEIGHT*SCALE));
        this.addKeyListener(this);

        player = new Player(100, HEIGHT-10);
        enemy = new Enemy(100, 0);

        layer = new BufferedImage(WIDHT, HEIGHT, BufferedImage.TYPE_INT_RGB);
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

        new Thread(game).start();
    }

    public void update(){
        player.update();
        enemy.update();
    }

    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            return;
        }
        Graphics g = layer.getGraphics();
        //Renderizando o fundo
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDHT, HEIGHT);
        
        //Renderizando o planer, enemy
        player.render(g);
        enemy.render(g);

        //Desenhando na tela
        g = bs.getDrawGraphics();
        g.drawImage(layer, 0, 0, WIDHT*SCALE, HEIGHT*SCALE, null);
        
        bs.show();
    }

    @Override
    public void run(){
        while(true){
            update();
            render();
            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent event) {
    
    }

    @Override
    public void keyPressed(KeyEvent event) {
        if(event.getKeyCode() == KeyEvent.VK_RIGHT){
            player.moveRight = true;
        }
        if(event.getKeyCode() == KeyEvent.VK_LEFT)
            player.moveLeft = true;
    }

    @Override
    public void keyReleased(KeyEvent event) {
        if(event.getKeyCode() == KeyEvent.VK_RIGHT){
            player.moveRight = false;
        }
        else if(event.getKeyCode() == KeyEvent.VK_LEFT)
            player.moveLeft = false;
        
    }
}