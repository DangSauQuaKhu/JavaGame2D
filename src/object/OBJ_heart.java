/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import javax.imageio.ImageIO;
import main.GamePanel;

/**
 *
 * @author ADMIN
 */
public class OBJ_heart extends OBJ_super{
    GamePanel gp;
    public OBJ_heart(GamePanel gp)
    {
        this.gp = gp;
        name = "Heart";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/ResImage/heart/heart_blank.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/ResImage/heart/heart_full.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/ResImage/heart/heart_half.png"));
            image = uTool.scaleImage(image, gp.titleSize,gp.titleSize);
            image2 = uTool.scaleImage(image2, gp.titleSize,gp.titleSize);
            image3 = uTool.scaleImage(image3, gp.titleSize,gp.titleSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
