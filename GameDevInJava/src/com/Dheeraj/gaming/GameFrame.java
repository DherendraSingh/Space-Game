package com.Dheeraj.gaming;
import javax.swing.JFrame;
public class GameFrame extends JFrame{
    public GameFrame()
    {   Board board = new Board();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Space War");
        add(board);
        setSize(1500,920);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args)
    {   new GameFrame();



    }
}