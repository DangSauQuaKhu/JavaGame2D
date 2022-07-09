/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enity;

import Demon.DE_bat;
import main.GamePanel;

/**
 *
 * @author ADMIN
 */
public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp)
    {
        this.gp= gp;
    }
    public void setBat() 
    {
      gp.bat[0] = new DE_bat(gp);
      gp.bat[0].worldX = gp.titleSize*23;
      gp.bat[0].worldY = gp.titleSize*36;
      
      gp.bat[1] = new DE_bat(gp);
      gp.bat[1].worldX = gp.titleSize*24;
      gp.bat[1].worldY = gp.titleSize*38;
      
      
      gp.bat[2] = new DE_bat(gp);
      gp.bat[2].worldX = gp.titleSize*12;
      gp.bat[2].worldY = gp.titleSize*32;
      
      gp.bat[3] = new DE_bat(gp);
      gp.bat[3].worldX = gp.titleSize*12;
      gp.bat[3].worldY = gp.titleSize*32;
      
      gp.bat[4] = new DE_bat(gp);
      gp.bat[4].worldX = gp.titleSize*12;
      gp.bat[4].worldY = gp.titleSize*32;
     
      gp.bat[5] = new DE_bat(gp);
      gp.bat[5].worldX = gp.titleSize*12;
      gp.bat[5].worldY = gp.titleSize*32;
       
    }
} 
