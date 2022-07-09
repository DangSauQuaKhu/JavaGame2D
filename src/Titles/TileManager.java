/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Titles;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.UtiltyTool;

/**
 *
 * @author ADMIN
 */
public class TileManager {
    GamePanel gp;
    public title[] Tile;
    public int mapTileNum[][];
    public TileManager(GamePanel gp)
    {
        this.gp = gp;
        Tile = new title[50];
        mapTileNum= new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap();
       
    }
    public  void getTileImage()
    {
        try {
            for(int i=0; i<11; i++)
            {
            Tile[i] = new title();
            Tile[i].image = ImageIO.read(getClass().getResourceAsStream("/ResImage/title/grass00.png"));
            }
            Tile[11] = new title();
            Tile[11].image = ImageIO.read(getClass().getResourceAsStream("/ResImage/title/grass01.png"));
           //water
           
            Tile[12] = new title();
            Tile[12].image = ImageIO.read(getClass().getResourceAsStream("/ResImage/title/water00.png"));
            Tile[12].collistion = true;
            Tile[13] = new title();
            Tile[13].image = ImageIO.read(getClass().getResourceAsStream("/ResImage/title/water01.png"));
            Tile[13].collistion = true;
            Tile[14] = new title();
            Tile[14].image = ImageIO.read(getClass().getResourceAsStream("/ResImage/title/water02.png"));
            Tile[14].collistion = true;
            Tile[15] = new title();
            Tile[15].image = ImageIO.read(getClass().getResourceAsStream("/ResImage/title/water03.png"));
            Tile[15].collistion = true;
            Tile[16] = new title();
            Tile[16].image = ImageIO.read(getClass().getResourceAsStream("/ResImage/title/water04.png"));
            Tile[16].collistion = true;
            Tile[17] = new title();
            Tile[17].image = ImageIO.read(getClass().getResourceAsStream("/ResImage/title/water05.png"));
            Tile[17].collistion = true;
            Tile[18] = new title();
            Tile[18].image = ImageIO.read(getClass().getResourceAsStream("/ResImage/title/water06.png"));
            Tile[18].collistion = true;
            Tile[19] = new title();
            Tile[19].image = ImageIO.read(getClass().getResourceAsStream("/ResImage/title/water07.png"));
            Tile[19].collistion = true;
            Tile[20] = new title();
            Tile[20].image = ImageIO.read(getClass().getResourceAsStream("/ResImage/title/water08.png"));
            Tile[20].collistion = true;
            Tile[21] = new title();
            Tile[21].image = ImageIO.read(getClass().getResourceAsStream("/ResImage/title/water09.png"));
            Tile[21].collistion = true;
            Tile[22] = new title();
            Tile[22].image = ImageIO.read(getClass().getResourceAsStream("/ResImage/title/water10.png"));
            Tile[22].collistion = true;
            Tile[23] = new title();
            Tile[23].image = ImageIO.read(getClass().getResourceAsStream("/ResImage/title/water11.png"));
            Tile[23].collistion = true;
            Tile[24] = new title();
            Tile[24].image = ImageIO.read(getClass().getResourceAsStream("/ResImage/title/water12.png"));
            Tile[24].collistion = true;
            Tile[25] = new title();
            Tile[25].image = ImageIO.read(getClass().getResourceAsStream("/ResImage/title/water13.png"));
            Tile[25].collistion = true;
            
            //road
            Tile[26] = new title();
            Tile[26].image = ImageIO.read(getClass().getResourceAsStream("/ResImage/title/road00.png"));
           
            Tile[27] = new title();
            Tile[27].image = ImageIO.read(getClass().getResourceAsStream("/ResImage/title/road01.png"));
            
            Tile[28] = new title();
            Tile[28].image = ImageIO.read(getClass().getResourceAsStream("/ResImage/title/road02.png"));
            
            Tile[29] = new title();
            Tile[29].image = ImageIO.read(getClass().getResourceAsStream("/ResImage/title/road03.png"));
           
            Tile[30] = new title();
            Tile[30].image = ImageIO.read(getClass().getResourceAsStream("/ResImage/title/road04.png"));
            
            Tile[31] = new title();
            Tile[31].image = ImageIO.read(getClass().getResourceAsStream("/ResImage/title/road05.png"));
            
            Tile[32] = new title();
            Tile[32].image = ImageIO.read(getClass().getResourceAsStream("/ResImage/title/road06.png"));
           
            Tile[33] = new title();
            Tile[33].image = ImageIO.read(getClass().getResourceAsStream("/ResImage/title/road07.png"));
            
            Tile[34] = new title();
            Tile[34].image = ImageIO.read(getClass().getResourceAsStream("/ResImage/title/road08.png"));
           
            Tile[35] = new title();
            Tile[35].image = ImageIO.read(getClass().getResourceAsStream("/ResImage/title/road09.png"));
            
            Tile[36] = new title();
            Tile[36].image = ImageIO.read(getClass().getResourceAsStream("/ResImage/title/road10.png"));
            
            Tile[37] = new title();
            Tile[37].image = ImageIO.read(getClass().getResourceAsStream("/ResImage/title/road11.png"));
           
            Tile[38] = new title();
            Tile[38].image = ImageIO.read(getClass().getResourceAsStream("/ResImage/title/road12.png"));
           
            //
            Tile[39] = new title();
            Tile[39].image = ImageIO.read(getClass().getResourceAsStream("/ResImage/title/earth.png"));
            Tile[40] = new title();
            Tile[40].image = ImageIO.read(getClass().getResourceAsStream("/ResImage/title/wall.png"));
            Tile[40].collistion = true;
            
           
            Tile[41] = new title();
            Tile[41].image = ImageIO.read(getClass().getResourceAsStream("/ResImage/title/tree.png"));
            Tile[41].collistion = true;
          
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
    public void loadMap()
    {
        try {
            InputStream is = getClass().getResourceAsStream("/ResImage/title/map.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col =0;
            int row =0;
            while (col<gp.maxWorldCol && row <gp.maxWorldRow)
            {
                String line = br.readLine();
                while(col<gp.maxWorldCol)
                {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                    
                }
                if(col==gp.maxWorldCol)
                {
                    col=0;
                    row++;
                }
                
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void draw (Graphics2D g2)
    {
        int worldCol =0;
        int worldRow = 0;
       
        // g2.drawImage(Tile[0].image, 0, 0, gp.titleSize, gp.titleSize, null);
        while (worldCol <gp.maxWorldCol && worldRow < gp.maxWorldRow)
        {
            int tileNum = mapTileNum[worldCol][worldRow];
            int worldX = worldCol * gp.titleSize;
            int worldY = worldRow *gp.titleSize;
            double screenX = worldX -gp.player.worldX + gp.player.screenX;
            double screeny = worldY -gp.player.worldY + gp.player.screenY;
            if(worldX+gp.titleSize>gp.player.worldX - gp.player.screenX &&
                    worldX- gp.titleSize<gp.player.worldX + gp.player.screenX && 
                    worldY + gp.titleSize>gp.player.worldY - gp.player.screenY &&
                    worldY- gp.titleSize <gp.player.worldY + gp.player.screenY)
            { g2.drawImage(Tile[tileNum].image,(int)screenX ,(int)screeny, gp.titleSize, gp.titleSize, null);}
            worldCol++;
           
            
            if(worldCol == gp.maxWorldCol)
            {
                worldCol =0; 
               
                worldRow++;
               
               
            }
        }
    }
    
}
