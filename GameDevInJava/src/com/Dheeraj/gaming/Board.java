package com.Dheeraj.gaming;
import sprites.Enemy;
import sprites.Player;

import javax.imageio.ImageIO;
import javax.swing.Timer;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Board extends JPanel{
    Timer timer;
     BufferedImage backgroundImage;
     Player player;
     Enemy enemies [] =new Enemy[5];
    public Board()
    {setSize(1600,920);
        loadBackgroundImage();
        player = new Player();

        loadEnemies();
        gameLoop();
        bindEvents();
        setFocusable(true);

    }
    private void gameOver(Graphics pen)
    {  if(player.outOfScreen()) {
        pen.setFont(new Font("times", Font.BOLD, 100));
        pen.setColor(Color.RED);
        pen.drawString("Game Win", 1500 / 2, 900 / 2);
        timer.stop();
        return;
    }
       for(Enemy enemy:enemies)
       {
           if (isCollide(enemy))
           {   pen.setFont(new Font("times",Font.BOLD,100));
               pen.setColor(Color.RED);
               pen.drawString("Game Over",1500/2,900/2);
               timer.stop();

           }
       }
    }
    private boolean isCollide(Enemy enemy)
    {
        int xDistance = Math.abs(player.x-enemy.x);
        int yDistance = Math.abs(player.y -enemy.y);
        int maxH = Math.max(player.h,enemy.h);
        int maxW = Math.max(player.w,enemy.w);
        return xDistance <=maxW-65&& yDistance <=maxH-65;
    }
    private void bindEvents()
    {
        addKeyListener(new KeyListener() {
                           @Override
                           public void keyTyped(KeyEvent e) {

                           }

                           @Override
                           public void keyPressed(KeyEvent e) {
                                 if(e.getKeyCode()==KeyEvent.VK_RIGHT)
                                 {
                                    player.speed =10;}
                                 else if(e.getKeyCode()==KeyEvent.VK_LEFT)
                               {
                                   player.speed = -10;
                               }

                           }

                           @Override
                           public void keyReleased(KeyEvent e) {
                             player.speed =0;
                           }
                       }
        );
    }
    public void loadEnemies()
    {   int x =400;
        int gap =250;
        int speed = 5;
        for(int i=0;i<enemies.length;i++)
        {
            enemies[i]= new Enemy(x,speed);
            x=x+gap;
            speed = speed+5;
        }
    }
    private void gameLoop()
    {
        timer = new Timer(50,(e)-> repaint());
        timer.start();
    }
    private void loadBackgroundImage()
    {   try {
         backgroundImage =ImageIO.read(Board.class.getResource("Background.jpg"));
    } catch(IOException e ){
        System.out.println("Background Image not found");
        System.exit(1);
        e.printStackTrace();
    }
    }
    private void printEnemies(Graphics pen)
    {
        for(Enemy enemy : enemies)
        {
            enemy.draw(pen);
            enemy.move();
        }
    }
    public void paintComponent(Graphics pen)
    {
        super.paintComponent(pen);
        pen.drawImage(backgroundImage,0,0,1500,920,null);
        player.draw(pen);
        player.move();
        printEnemies(pen);
        gameOver(pen);
    }

}
