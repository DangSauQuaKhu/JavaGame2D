/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author ADMIN
 */
public class KeyHandler implements KeyListener{
    public boolean  upPressed, downPressed, leftPressed, rightPressed,enterPressed;
    GamePanel gp;
    public KeyHandler(GamePanel gp)
    {
        this.gp = gp;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
       int code = e.getKeyCode(); 
       if(gp.gameState==gp.titleState)
       {
           if( code == KeyEvent.VK_UP)
       {
           gp.ui.commandNmber++;
           if(gp.ui.commandNmber<0)
           {
               gp.ui.commandNmber=1;
           }
       }
       if( code == KeyEvent.VK_DOWN)
       {
           gp.ui.commandNmber++;
           if(gp.ui.commandNmber>1)
           {
               gp.ui.commandNmber=0;
           }
       }
       if(code== KeyEvent.VK_ENTER)
       {
           if(gp.ui.commandNmber==0)
           {
               gp.gameState=gp.playSate;
           }
           if(gp.ui.commandNmber==1)
           {
               System.exit(0);
           }
       }
       }
       if( code == KeyEvent.VK_UP)
       {
           upPressed= true;
       }
       if( code == KeyEvent.VK_DOWN)
       {
           downPressed= true;
       }
       if( code == KeyEvent.VK_LEFT)
       {
           leftPressed = true;
       }
       if( code == KeyEvent.VK_RIGHT)
       {
           rightPressed = true;
       }
       if(code == KeyEvent.VK_A)
       {
           enterPressed = true;
       }
       if(code == KeyEvent.VK_P)
           if(gp.gameState==gp.playSate)
               gp.gameState = gp.pauseState;
           else if(gp.gameState==gp.pauseState)
               gp.gameState = gp.playSate;
       if( code == KeyEvent.VK_X)
       {
           gp.zoomInOut(1);
       }
       if( code == KeyEvent.VK_Y)
       {
           gp.zoomInOut(-1);
       }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode(); 
       if( code == KeyEvent.VK_UP)
       {
           upPressed= false;
       }
       if( code == KeyEvent.VK_DOWN)
       {
           downPressed= false;
       }
       if( code == KeyEvent.VK_LEFT)
       {
           leftPressed = false;
       }
       if( code == KeyEvent.VK_RIGHT)
       {
           rightPressed = false;
       }
    }
     
    
}
