package sprites;
import javax.swing.ImageIcon;
import java.awt.Graphics;

public class Enemy extends Sprite{

    public Enemy(int x,int speed )
    {
        y =200;
        this.x = x;
        this.speed = speed;
        x =1000;
        w =150;
        h = 150;
        image = new ImageIcon(Enemy.class.getResource("alien.gif"));
    }
    public void move()
    {   if(y>900)
       {
           y = 0;
       }
        y = y+speed;
    }




}
