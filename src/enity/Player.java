/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.management.timer.TimerMBean;
import main.GamePanel;
import main.KeyHandler;
import main.UtiltyTool;

/**
 *
 * @author ADMIN
 */
public class Player extends Enity {


    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    public Player(GamePanel gp,KeyHandler keyH)  {
        super(gp);
        this.keyH = keyH;
        screenX = gp.screenWidth/2 - gp.titleSize/2;
        screenY = gp.screenHeight/2 - gp.titleSize/2;
        soliArea = new Rectangle();
        soliArea.x =8;
        soliArea.y=16;
        solidAreaDefaultX = soliArea.x;
        solidAreaDefaultY = soliArea.y;
        soliArea.height=32;
        soliArea.width=32;
        AttsoliArea.width =36;
        AttsoliArea.height =36;
        setDefaultValues();
        getPlayerImage();
        getPlayerAttackImage();
    }

    public void setDefaultValues() {
        worldX = gp.titleSize*20;
        worldY = gp.titleSize*20;
        //speed = 4;
        speed = gp.worldWidth/600;
        direction = "down";
        maxLife = 6;
        life = maxLife; 
    }

    public void getPlayerImage()  {
        try {
            up1    = ImageIO.read(getClass().getResourceAsStream("/ResImage/player/boy_up_1.png"));
        //   up1 = unTool.scaleImage(up1, gp.titleSize,gp.titleSize*2);
            up2    = ImageIO.read(getClass().getResourceAsStream("/ResImage/player/boy_up_2.png"));
           //up2 = unTool.scaleImage(up2, gp.titleSize,gp.titleSize);
            down1  = ImageIO.read(getClass().getResourceAsStream("/ResImage/player/boy_down_1.png"));
           // down1 = unTool.scaleImage(down1, gp.titleSize,gp.titleSize);
            down2  = ImageIO.read(getClass().getResourceAsStream("/ResImage/player/boy_down_2.png"));
           //down2 = unTool.scaleImage(down2, gp.titleSize,gp.titleSize);
            left1  = ImageIO.read(getClass().getResourceAsStream("/ResImage/player/boy_left_1.png"));
          //left1 = unTool.scaleImage(left1, gp.titleSize,gp.titleSize);
            left2  = ImageIO.read(getClass().getResourceAsStream("/ResImage/player/boy_left_2.png"));
           // left2 = unTool.scaleImage(left2, gp.titleSize,gp.titleSize);
            right1 = ImageIO.read(getClass().getResourceAsStream("/ResImage/player/boy_right_1.png"));
          //  right1 = unTool.scaleImage(right1, gp.titleSize,gp.titleSize);
            right2 = ImageIO.read(getClass().getResourceAsStream("/ResImage/player/boy_right_2.png"));
           // right2 = unTool.scaleImage(right2, gp.titleSize,gp.titleSize);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void getPlayerAttackImage()  {
        try {
            attUp1   = ImageIO.read(getClass().getResourceAsStream("/ResImage/player_att/boy_up_1_att.png"));
            attUp1 = unTool.scaleImage(attUp1, gp.titleSize,gp.titleSize*2);
            attUp2  = ImageIO.read(getClass().getResourceAsStream("/ResImage/player_att/boy_up_2_att.png"));
            attUp2 = unTool.scaleImage(attUp2, gp.titleSize,gp.titleSize*2);
            attDown1  = ImageIO.read(getClass().getResourceAsStream("/ResImage/player_att/boy_down_1_att.png"));
            attDown1 = unTool.scaleImage(attDown1, gp.titleSize,gp.titleSize*2);
            attDown2  = ImageIO.read(getClass().getResourceAsStream("/ResImage/player_att/boy_down_2_att.png"));
            attDown2 = unTool.scaleImage(attDown2 , gp.titleSize,gp.titleSize*2);
            attLeft1  = ImageIO.read(getClass().getResourceAsStream("/ResImage/player_att/boy_left_1_att.png"));
            attLeft1 = unTool.scaleImage(attLeft1, gp.titleSize*2,gp.titleSize);
            attLeft2  = ImageIO.read(getClass().getResourceAsStream("/ResImage/player_att/boy_left_2_att.png"));
           attLeft2 = unTool.scaleImage(attLeft2, gp.titleSize*2,gp.titleSize);
            attRight1 = ImageIO.read(getClass().getResourceAsStream("/ResImage/player_att/boy_right_1_att.png"));
           attRight1 = unTool.scaleImage(attRight1, gp.titleSize*2,gp.titleSize);
            attRight2 = ImageIO.read(getClass().getResourceAsStream("/ResImage/player_att/boy_right_2_att.png"));
           attRight2 = unTool.scaleImage( attRight2, gp.titleSize*2,gp.titleSize);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
    public void update() {
       
            attacking();
        
       
        
         if(keyH.upPressed==true || keyH.downPressed ==true || keyH.rightPressed == true || keyH.leftPressed ==true )
        {
             if (keyH.upPressed == true) 
            direction = "up";
           

         else if (keyH.downPressed) {
            direction = "down";
           
        }
        if (keyH.leftPressed == true) {
            direction = "left";
          
        } else if (keyH.rightPressed == true) {
            direction = "right";
           
        }
        collisionOn = false;
        gp.checker.checkTile(this);
        
        
        int batIndex = gp.checker.checkBat(gp.bat, this);
         interactBat(batIndex);
         attackBat(batIndex);
        
        if(collisionOn==false)
        {
            switch(direction)
            {
            case "up":
                worldY -= speed;

                break;
            case "down":
                 worldY += speed;
                break;
            case "left":
                worldX -= speed;
                break;
            case "right":
                worldX += speed;
                break;
            }
        }
        SpriteCounter++;
        if (SpriteCounter > 12) {
            if (SpriteNum == 1) {
                SpriteNum = 2;
            } else if (SpriteNum == 2) {
                SpriteNum = 1;
            }
            SpriteCounter = 0;
        }
        
        
        }
         attackCounter++;
        if(attackCounter>40)
        {
            keyH.enterPressed =false;
            attacking=false;
            attackCounter =0;
        }
        if(beHurt==true)
        {
                timBeHurt++;
                if(timBeHurt>60)
                { beHurt = false;
                    timBeHurt =0;
                }
                System.out.println(timBeHurt);
        }
       
    }
    public void interactBat(int i)
    {
        if(i!=999)
        {
            System.out.println("you hit");
            if(beHurt == false)
            { 
             life-=1;
            beHurt = true;
            }
        }
            if(life<=0)
            {
                gp.gameState = gp.overState;
            }
    }
    public void attackBat(int i)
    {   
        if(i!=999){
         if(attacking == true &&gp.bat[i].beHurt == false )
         {
             gp.bat[i].life-=2;
             System.out.println(i+" "+gp.bat[i].life);
            gp.bat[i].beHurt = true;
         }
       if(gp.bat[i].life<=0) gp.bat[i]=null;
        }
    }
    public void attacking()
    {
       if(keyH.enterPressed==true){ attacking =true;
       int currentWorldX = worldX;
       int currentWorldY = worldY;
       int solidAreaWidth = soliArea.width;
       int solidAreaHeight = soliArea.height;
       switch(direction)
       {
           case "up":
               worldY -= AttsoliArea.height; break;
           case "down":
               worldY +=AttsoliArea.height; break;
           case "left":
               worldX -= AttsoliArea.width;break;
           case "right":
               worldX +=AttsoliArea.width;break;
       }
       int batIndex = gp.checker.checkBat(gp.bat, this);
       attackBat(batIndex);
       worldX = currentWorldX;
       worldY =currentWorldY;
       soliArea.width =solidAreaWidth;
       soliArea.height=solidAreaHeight;
       }
      
    }

    public void draw(Graphics2D g2) {
        // g2.setColor(Color.white);
        // g2.fillRect(x, y, gp.titleSize, gp.titleSize);
        BufferedImage image = null;
        int temScreenX = screenX;
        int temScreenY = screenY;
        switch (direction) {
           case "up":
               if(attacking==false)
               {
                    if (SpriteNum == 1) {
                    image = up1;
                } 
                if(SpriteNum == 2){
                    image = up2;
                }
               }
              
                 if(attacking==true)
                 {
                     temScreenY = screenY - gp.titleSize;
                   if (SpriteNum == 1) {
                    image = attUp1;
                   } 
                if(SpriteNum == 2){
                    image = attUp2;
                      }
                  }
               
                break;
            case "down":
                 if(attacking==false)
               {
                    if (SpriteNum == 1) {
                    image = down1;
                }
                if(SpriteNum == 2) {
                    image = down2;
                }
               }
              
                 if(attacking==true)
                 {
                     
                   if (SpriteNum == 1) {
                    image = attDown1;
                }
                if(SpriteNum == 2) {
                    image = attDown2;
                }
                  }
                
                break;
            case "left":
                if(attacking==false)
               {
                    if (SpriteNum == 1) {
                    image = left1;
                } 
                if(SpriteNum == 2){
                    image = left2;
                }
               }
              
                 if(attacking==true)
                 {
                     temScreenX = screenX - gp.titleSize;
                   if (SpriteNum == 1) {
                    image = attLeft1;
                }
                if(SpriteNum == 2) {
                    image = attLeft2;
                }
                  }
                
                break;
            case "right":
                if(attacking==false)
               { 
                    if (SpriteNum == 1) {
                    image = right1;
                } 
                if(SpriteNum == 2){
                    image = right2;
                }
               }
              
                 if(attacking==true)
                 {
                      
                     if (SpriteNum == 1) {
                    image = attRight1;
                } 
                if(SpriteNum == 2){
                    image = attRight2;
                }
                  }
                
                break;
        }
       
       
       
        if(beHurt==true)
        {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
        }
        if(attacking==true)
         g2.drawImage(image, temScreenX, temScreenY,  null);
        else
        {
             g2.drawImage(image, temScreenX, temScreenY,gp.titleSize,gp.titleSize,null);
        }
         g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
    }
}
