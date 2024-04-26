package sprites;

import javax.swing.*;
import java.awt.*;

public class Player extends Sprite {


    public Player()
    {
        w=150;
        h=150;
        x=50;
        y=600;
        image = new ImageIcon(Player.class.getResource("plane.gif"));
    }
    public void move()
    {
        x= x+speed;
    }
    public boolean outOfScreen()
    {
        return x>1500;
    }

}
