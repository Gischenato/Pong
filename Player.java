import java.awt.Color;
import java.awt.Graphics;

public class Player {

     public boolean moveRight, moveLeft;
     public int x,y;

     public int widht, height;

     public final int SPEED;

     public Player(int x, int y) {
          this.x = x;
          this.y = y;
          this.widht = 50;
          this.height = 10;
          this.SPEED = 2;
     }

     public void update(){
          if (moveRight){
               x += SPEED;
          }
          else if(moveLeft){
               x -= SPEED;
          }

          //Checando colisao com parede
          if(x + widht > Game.WIDHT) x = Game.WIDHT - widht;
          if(x < 0) x = 0;
     }    


     
     public void render(Graphics g){
          g.setColor(Color.BLUE);
          g.fillRect(x, y, widht, height);
     }
}