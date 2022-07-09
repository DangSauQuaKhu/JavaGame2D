/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import main.GamePanel;
import main.UtiltyTool;

/**
 *
 * @author ADMIN
 */
public class Enity {
    public GamePanel gp;
    public int worldX,worldY;
    public int speed;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public BufferedImage attUp1, attUp2, attDown1, attDown2, attLeft1, attLeft2, attRight1, attRight2;
    public String direction;
    public int SpriteCounter =0;
    public int attackCounter =0;
    public int SpriteNum =1;
    public Rectangle soliArea = new Rectangle(0,0,48,48);
    public Rectangle AttsoliArea = new Rectangle(0,0,0,0);
    public boolean  collisionOn = false;
    public int maxLife;
    public int life;
    public int actionLockCounter =0;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean beHurt = false;
    public int timBeHurt = 0;
    public UtiltyTool unTool = new UtiltyTool();
    public boolean attacking =false;
    public Enity(GamePanel gp)
    {
        this.gp = gp;
    }

    public void draw(Graphics2D g2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
         
}
