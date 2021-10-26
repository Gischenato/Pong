import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {

     public double x,y;
     public int widht, height;

     public double dx, dy;
     public final double SPEED = 2.2;


     public Ball(int x, int y){
          this.x = x;
          this.y = y;
          this.widht = 5;
          this.height = 5;

          int angle = new Random().nextInt(120 -45) + 45;
          this.dx = Math.cos(Math.toRadians(angle)); 
          this.dy = Math.sin(Math.toRadians(angle));
     }

     public void update(){
          //Checando colisao da bola
          if(x + dx*SPEED + widht >= Game.WIDHT) dx *= -1;
          else if(x + dx*SPEED < 0) dx *= -1;

          if( y >= Game.HEIGHT){
               //PONTO DO INIMIGO
               System.out.println("PONTO DO INIMIGO");
               new Game();
               return;
          }
          else if( y < 0){
               //PONTO DO JOGADOR
               System.out.println("PONTO DO JOGADOR");
               new Game();
               return;
          }

          //Criando retangulos de colisao
          Rectangle bounds = new Rectangle((int)(x + dx*SPEED), (int)(y + dy*SPEED), widht, height);
          Rectangle playerBounds = new Rectangle(Game.player.x, Game.player.y, Game.player.widht, Game.player.height);
          Rectangle enemyBounds = new Rectangle((int)Game.enemy.x, (int)Game.enemy.y, Game.enemy.widht, Game.enemy.height);
          
          Double ballCenter = bounds.getCenterX();
          Double playerCenter = playerBounds.getCenterX();
          Double enemyCenter = enemyBounds.getCenterX();

          if(bounds.intersects(playerBounds) || bounds.intersects(enemyBounds)){
               dy *= -1;
               if(ballCenter >= playerCenter) mudaDx(false);
               else if(ballCenter < playerCenter) mudaDx(true);
               else if(ballCenter >= enemyCenter) mudaDx(true);
               else if(ballCenter < enemyCenter) mudaDx(false);

          }


          x += dx*SPEED;
          y += dy*SPEED;
     }

     public void mudaDx(Boolean esquerda){
          if(esquerda){
               dx  = Math.cos(Math.toRadians(new Random().nextInt(70) + 110));
               System.out.println(dx);
          }else{
               dx = Math.cos(Math.toRadians(new Random().nextInt(75)));
          }
     }
     
     public void render(Graphics g){
          g.setColor(Color.BLACK);
          g.fillRect((int)x, (int)y, widht, height);
     }
     
}