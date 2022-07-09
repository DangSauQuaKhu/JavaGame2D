/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demon;

import enity.Enity;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;

/**
 *
 * @author ADMIN
 */
public class DE_bat extends Enity{
    KeyHandler keyH;
    public int screenX;
    public int screenY;
    public boolean die = false;
    public DE_bat(GamePanel gp)  {
        super(gp);
        soliArea = new Rectangle();
        soliArea.x =8;
        soliArea.y=16;
        
        solidAreaDefaultX = soliArea.x;
        solidAreaDefaultY = soliArea.y;
        soliArea.height=32;
        soliArea.width=32;
        setDefaultValues();
        getImage();
    }
    public void setDefaultValues() {
        worldX = gp.titleSize*30;
        worldY = gp.titleSize*30;
        //speed = 4;
        speed = 1;
        direction = "down";
        maxLife = 6;
        life = maxLife; 
    }


    public void getImage(){
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/ResImage/demon/bat/bat1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/ResImage/demon/bat/bat2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/ResImage/demon/bat/bat3.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/ResImage/demon/bat/bat4.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/ResImage/demon/bat/bat1.png"));
            left2= ImageIO.read(getClass().getResourceAsStream("/ResImage/demon/bat/bat2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/ResImage/demon/bat/bat3.png"));
            right2= ImageIO.read(getClass().getResourceAsStream("/ResImage/demon/bat/bat4.png"));
        } catch (IOException ex) {
            Logger.getLogger(DE_bat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void update() {
   
        setAction();
        collisionOn = false;
        gp.checker.checkTile(this);
        if(speed==5) System.out.println(collisionOn);
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
        if(beHurt==true)
        {
                timBeHurt++;
                if(timBeHurt>60)
                { beHurt = false;
                    timBeHurt =0;
                }
        }
        
       
    }

    public void draw(Graphics2D g2) {
        // g2.setColor(Color.white);
        // g2.fillRect(x, y, gp.titleSize, gp.titleSize);
        screenX = worldX - gp.player.worldX+ gp.player.screenX;
        screenY = worldY - gp.player.worldY + gp.player.screenY;
       
        BufferedImage image = null;
        switch (direction) {
           case "up":
                if (SpriteNum == 1) {
                    image = up1;
                } 
                if(SpriteNum == 2){
                    image = up2;
                }
                break;
            case "down":
                if (SpriteNum == 1) {
                    image = down1;
                }
                if(SpriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (SpriteNum == 1) {
                    image = left1;
                } 
                if(SpriteNum == 2){
                    image = left2;
                }
                break;
            case "right":
                if (SpriteNum == 1) {
                    image = right1;
                } 
                if(SpriteNum == 2){
                    image = right2;
                }
                break;
        }
        if(life<=0) 
        {
            die = true;
           
        }
        if(die == false)
        {
             if(beHurt==false)
        g2.drawImage(image, screenX, screenY, gp.titleSize, gp.titleSize, null);
             else
             {
                  g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
                   g2.drawImage(image, screenX, screenY, gp.titleSize, gp.titleSize, null);
                   g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
             }
        }
    }
    public void setAction()
    {
       actionLockCounter++;
       if(actionLockCounter == 50)
       {
           Random random = new Random();
           int i = random.nextInt(40)+1;
           if(i<=15)
           {
               direction = "up";
           }
           if(i>15 && i<=28)
           {
               direction = "down";
           }
           if(i>29 && i<=35)
               {
               direction = "left";
           }
           if(i>35 && i<41)
           {
               direction = "right";
               
           }
           actionLockCounter =0;
       }
    }
}
