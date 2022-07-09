/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import main.GamePanel;
import main.UtiltyTool;

/**
 *
 * @author ADMIN
 */
public class OBJ_super {
    public BufferedImage image, image2, image3;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX=0;
    public int solidAreaDefaultY=0;
    public UtiltyTool uTool = new UtiltyTool();
    public void draw (Graphics2D g2, GamePanel gp)
    {
        int screenX = worldX - gp.player.worldX+ gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
        if(worldX+gp.titleSize>gp.player.worldX  -  gp.player.screenX &&
             worldX-gp.titleSize>gp.player.worldX +  gp.player.screenX && 
              worldY+gp.titleSize>gp.player.worldY  -  gp.player.screenY &&
                worldY - gp.titleSize>gp.player.worldY  +  gp.player.screenY )
        {
            g2.drawImage(image,screenX,screenY,gp.titleSize,gp.titleSize,null);
        }
    }
    
}
