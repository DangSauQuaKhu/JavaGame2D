/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Demon.DE_bat;
import Titles.TileManager;
import enity.AssetSetter;
import enity.Enity;
import enity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import object.OBJ_heart;

/**
 *
 * @author ADMIN
 */
public class GamePanel extends JPanel implements Runnable{
    final int originalTitleSize = 16;
    final int scale = 3;
    public int titleSize = originalTitleSize *scale;
    public int maxScreenCol = 14;
    public int maxScreenRow = 14;
    public int screenWidth = titleSize * maxScreenCol;
    public int  screenHeight = titleSize *maxScreenRow;
    // world
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = titleSize * maxWorldCol;
    public final int worldHeight = titleSize + maxWorldRow;
    Thread gameThread;
    public CollisionChecker checker = new CollisionChecker(this);
    KeyHandler keyH = new KeyHandler(this);
    public UI ui = new UI(this);
    TileManager tileManager = new TileManager(this);
    public Player player = new Player(this,keyH);
    public DE_bat bat[]= new DE_bat[20];
    
    public OBJ_heart heart = new OBJ_heart(this);
    public int gameState =1 ;
    public final int titleState =0;
    public final int playSate =1;
    public final int pauseState =2;
    public final int overState =3;
    public final int winState = 4;
    public AssetSetter aSetter = new AssetSetter(this);
    
    int FPS = 60;
    
    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    public void setupGame()
    {
        gameState = titleState;
        aSetter.setBat();
     
        
    }
    public void zoomInOut(int i)
    {
        int oldWorldWidth = titleSize * maxWorldCol;
         titleSize+=i;
         int newWorldWidth = titleSize*maxWorldCol;
         player.speed = (int) newWorldWidth/600;
         double multiplier = (double) newWorldWidth/oldWorldWidth;
         System.out.println("tilesize : "+ titleSize);
         System.out.println("newWorldWidth : "+ worldWidth);
         System.out.println("player : "+ player.worldX);
         double newPlayerWorldX = player.worldX* multiplier;
         double newPlayerWorldY = player.worldY* multiplier;
         player.worldX = (int) newPlayerWorldX;
         player.worldY = (int) newPlayerWorldY;
         
    }
    public void  startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
  /*  public void run()
    {
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime()+drawInterval;
        while(gameThread != null)
        {
            
           // System.out.println("The game loop running");
            //information
            update();
            //draw
            repaint();
            
            
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
            remainingTime= remainingTime/1000000;
            if(remainingTime<0)
            {
                remainingTime =0;
            }
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }*/
    public void run(){
        double drawInterval = 1000000000/FPS;
        double dental = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        int timer = 0;
        int drawCount = 0;
        while(gameThread !=null)
        {
            currentTime = System.nanoTime();
            dental+= (currentTime-lastTime)/drawInterval;
            timer += (currentTime-lastTime);
            lastTime = currentTime;
            
            if (dental>=1) {
                update();
                repaint();
                dental--;
                drawCount++;
            }
            if(timer>=1000000000)
            {
               // System.out.println("FPS:" +drawCount);
                drawCount=0;
                timer=0;
                
            }
        }
    }
    public void update()
    {
        if(gameState==playSate)
        {
          player.update();
         
          for(int i=0; i<bat.length; i++)
          {
              if(bat[i]!=null)
              {
                  bat[i].update();
              }
          }
        }
        if(gameState==pauseState)
        {
            
        }
        
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if(gameState == titleState)
        {
             ui.draw(g2);
             
        }
        if (gameState==overState) {
            ui.draw(g2);
            
        }
        if(gameState==winState)
        {
            ui.draw(g2);
        }
        else{
        tileManager.draw(g2);
        ui.drawPlayerLife();
        player.draw(g2);
       for(int i=0; i<bat.length; i++)
          {
              if(bat[i]!=null&& bat[i].die==false)
              {
                  bat[i].draw(g2);
              }
          }
         ui.draw(g2);
         
         
        }
        
        g2.dispose();
    }
}
