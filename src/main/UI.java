/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.security.spec.NamedParameterSpec;
import object.OBJ_heart;
import object.OBJ_super;

/**
 *
 * @author ADMIN
 */
public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font arial_40;
    public int commandNmber=0;
    BufferedImage heart_full, heart_half, heart_blank;
    public UI(GamePanel gp)
    {
        this.gp=gp;
        arial_40= new Font("Arial",Font.PLAIN,40);
        OBJ_super heart = new OBJ_heart(gp);
        heart_full = heart.image2;
        heart_half = heart.image3;
        heart_blank = heart.image;
        
    }
    public void draw(Graphics2D g2)
    {
        g2.setFont(arial_40);
        g2.setColor(Color.WHITE);
        
        this.g2 = g2;
        if(gp.gameState == gp.titleState)
        {
            drawTitleScreen();
        }
        if(gp.gameState==gp.playSate)
        {
            drawPlayerLife();
        }
         if(gp.gameState==gp.pauseState)
        {
            drawPauseScreen();
        }
         if(gp.gameState == gp.overState)
         {
             drawOverScreen();
         }
         if(gp.gameState==gp.winState)
         {
             drawWinScreen();
         }
    }
    public void drawPauseScreen()
    {
        String text = "PAUSE";
        int x = getXforCenterText(text);
        int y = gp.screenHeight/2;
        g2.drawString(text, x, y);
    }
    public int getXforCenterText(String text){
        int lenght = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x= gp.screenWidth/2-lenght/2;
        return x;
    }
    public void drawPlayerLife()
    {
        
        int x = gp.titleSize/2;
        int y = gp.titleSize/2;
        int i= 0;
        while(i<gp.player.maxLife/2)
        {
            g2.drawImage(heart_blank, x, y, null);
            i++;
            x+=gp.titleSize;
        }
         ///
        x = gp.titleSize/2;
        y = gp.titleSize/2;
        i= 0;
        while(i<gp.player.life)
        {
             g2.drawImage(heart_half, x, y, null);
             i++;
             if(i<gp.player.life)
             {
                  g2.drawImage(heart_full, x, y, null);
             }
             i++;
              x+=gp.titleSize;
                 
        }
        
    }
    public void drawTitleScreen()
    {
       // g2.setColor(new Color(70,120,80));
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
        g2.setFont(new Font("Arial",Font.BOLD,40));
        String text = "Game chua nghi ten, =)))";
        int x = getXforCenterText(text);
        int y = gp.titleSize*3;
        g2.setColor(Color.WHITE);
        g2.drawString(text, x, y);
        x = gp.screenWidth/2-gp.titleSize;
        y += gp.titleSize*2;
        g2.drawImage(gp.player.down1, x,y, gp.titleSize*2,gp.titleSize*2,null);
        g2.setFont(arial_40);
        text = "NEW GAME";
        x= getXforCenterText(text);
        y+=gp.titleSize*4;
        g2.setColor(Color.WHITE);
        g2.drawString(text, x, y);
        if(commandNmber==0)
        {
            g2.drawString(">", x-gp.titleSize, y);
        }
        text = "QUIT";
        x= getXforCenterText(text);
        y+=gp.titleSize;
        g2.setColor(Color.WHITE);
        g2.drawString(text, x, y);
        if(commandNmber==1)
        {
            g2.drawString(">", x-gp.titleSize, y);
        }
    }
     public void drawOverScreen()
    {
       // g2.setColor(new Color(70,120,80));
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
        g2.setFont(new Font("Arial",Font.BOLD,40));
        String text = "Ban da thua";
        int x = getXforCenterText(text);
        int y = gp.titleSize*3;
        g2.setColor(Color.WHITE);
        g2.drawString(text, x, y);
        x = gp.screenWidth/2-gp.titleSize;
        y += gp.titleSize*2;
        g2.drawImage(gp.player.down1, x,y, gp.titleSize*2,gp.titleSize*2,null);
        g2.setFont(arial_40);
        
    }
     public void drawWinScreen()
    {
       // g2.setColor(new Color(70,120,80));
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
        g2.setFont(new Font("Arial",Font.BOLD,40));
        String text = "Chuc mung ban da chien thang";
        int x = getXforCenterText(text);
        int y = gp.titleSize*3;
        g2.setColor(Color.WHITE);
        g2.drawString(text, x, y);
        x = gp.screenWidth/2-gp.titleSize;
        y += gp.titleSize*2;
        g2.drawImage(gp.player.down1, x,y, gp.titleSize*2,gp.titleSize*2,null);
        g2.setFont(arial_40);
       
    }
}
