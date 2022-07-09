/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Demon.DE_bat;
import enity.Enity;
import enity.Player;
import javax.swing.text.html.parser.Entity;

/**
 *
 * @author ADMIN
 */
public class CollisionChecker {
    GamePanel gp;
    public CollisionChecker(GamePanel gp)
    {
        this.gp = gp;
    }
    public void checkTile(Enity enity)
    {
        int entityLeftWorldX =  (enity.worldX + enity.soliArea.x);
        int entityRightWorldX =  (enity.worldX + enity.soliArea.x + enity.soliArea.width);
        int entityTopWorldY =  (enity.worldY + enity.soliArea.y);
        int entityBotWorldY =  (enity.worldY+ enity.soliArea.y+enity.soliArea.height);
        int entityLeftCol = entityLeftWorldX/gp.titleSize;
        int entityRightCol = entityRightWorldX/gp.titleSize;
        int entityTopRow = entityTopWorldY/gp.titleSize;
        int entityBotRow = entityBotWorldY/gp.titleSize;
        int tileNum1 = 0,tileNum2=0;
       
        switch(enity.direction)
        {
            case "up":
                entityTopRow =  (entityTopWorldY-enity.speed)/gp.titleSize;
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
                 if(tileNum1==39 || tileNum2 == 39) gp.gameState = gp.winState;
                if(gp.tileManager.Tile[tileNum1].collistion==true|| gp.tileManager.Tile[tileNum2].collistion==true)
                {
                    enity.collisionOn=true;
                }
                break;
            case "down":
                entityBotRow = (entityTopWorldY +enity.speed)/gp.titleSize;
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityBotRow];
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityBotRow];
                if(tileNum1==39 || tileNum2 == 39) gp.gameState = gp.winState;
                if(gp.tileManager.Tile[tileNum1].collistion==true|| gp.tileManager.Tile[tileNum2].collistion==true)
                {
                    enity.collisionOn=true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - enity.speed)/gp.titleSize;
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileManager.mapTileNum[entityLeftCol][entityBotRow];
                if(tileNum1==39 || tileNum2 == 39) gp.gameState = gp.winState;
                if(gp.tileManager.Tile[tileNum1].collistion==true|| gp.tileManager.Tile[tileNum2].collistion==true)
                {
                    enity.collisionOn=true;
                }
                break;
            case "right":
                entityRightCol = (entityLeftWorldX + enity.speed)/gp.titleSize;
                tileNum1 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityBotRow];
                if(tileNum1==39 || tileNum2 == 39) gp.gameState = gp.winState;
                if(gp.tileManager.Tile[tileNum1].collistion==true|| gp.tileManager.Tile[tileNum2].collistion==true)
                {
                    enity.collisionOn=true;
                }
                break;
                
        }
    }
    public int checkBat(Enity[] bat, Enity pl)
    {
        int index = 999;
         
        for(int i =0; i< bat.length-1; i++)
        {
            
            if(bat[i] !=null)
                {
                    
                    pl.soliArea.x = pl.worldX + pl.soliArea.x;
                    pl.soliArea.y = pl.worldY + pl.soliArea.y;
                    
                    bat[i].soliArea.x = bat[i].worldX + bat[i].soliArea.x;
                     bat[i].soliArea.y = bat[i].worldY + bat[i].soliArea.y;
                    switch(pl.direction)
                    {
                        case "up":
                            pl.soliArea.y -= pl.speed;
                            if(pl.soliArea.intersects(bat[i].soliArea))
                            {
                                
                                    pl.collisionOn = true;
                                    index =i;
                            
                            }
                            
                            break;
                            case "down":
                            pl.soliArea.y += pl.speed;
                            if(pl.soliArea.intersects(bat[i].soliArea))
                            {
                                 pl.collisionOn = true;
                                    index =i;
                            
                            }
                            break;
                        
                            case "left":
                            pl.soliArea.x -= pl.speed;
                            if(pl.soliArea.intersects(bat[i].soliArea))
                            {
                                 pl.collisionOn = true;
                                    index =i;
                            
                            }
                            break;
                            case "right":
                            pl.soliArea.x += pl.speed;
                            if(pl.soliArea.intersects(bat[i].soliArea))
                            {
                                 pl.collisionOn = true;
                                    index =i;
                            
                            }
                            break;
                    }
                    pl.soliArea.x = pl.solidAreaDefaultX;
                     pl.soliArea.y = pl.solidAreaDefaultY;
                     bat[i].soliArea.x = bat[i].solidAreaDefaultX;
                     bat[i].soliArea.y = bat[i].solidAreaDefaultY;
                     
                }
                     
                    
           
        }
        return index;
    }
}
