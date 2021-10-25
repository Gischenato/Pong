import java.awt.Color;
import java.awt.Graphics;

public class Player {

     public boolean moveRight, moveLeft;
     public int x,y;

     public int widht, height;

     public Player(int x, int y) {
          this.x = x;
          this.y = y;
          this.widht = 50;
          this.height = 10;
     }

     public void tick(){
          if (moveRight){
               x++;
          }
          else if(moveLeft){
               x--;
          }
     }    


     
     public void render(Graphics g){
          g.setColor(Color.BLUE);
          g.fillRect(x, y, widht, height);
     }
}