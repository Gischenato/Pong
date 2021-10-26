import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball {

     public double x,y;
     public int widht, height;

     public double dx, dy;
     public final double SPEED = 1.6;


     public Ball(int x, int y){
          this.x = x;
          this.y = y;
          this.widht = 5;
          this.height = 5;

          this.dx = new Random().nextGaussian(); 
          this.dy = new Random().nextGaussian();
     }

     public void update(){
          x += dx*SPEED;
          y += dy*SPEED;
     }
     
     public void render(Graphics g){
          g.setColor(Color.BLACK);
          g.fillRect((int)x, (int)y, widht, height);
     }
     
}