import java.awt.Color;
import java.awt.Graphics;

public class Enemy {

     public double x,y;
     public int widht, height;

     public Enemy(int x, int y){
          this.x = x;
          this.y = y;
          this.widht = 50;
          this.height = 10;
     }

     public void update(){

     }
     
     public void render(Graphics g){
          g.setColor(Color.RED);
          g.fillRect((int)x, (int)y, widht, height);
     }
     
}