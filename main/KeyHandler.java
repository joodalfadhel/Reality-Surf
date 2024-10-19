package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


//KeyListener: he listener interface for receiving keyboard events (keystrokes
public class KeyHandler implements KeyListener {
    
    //for keyevents -> if pressed
    public boolean up, down, left, right;

    @Override
    //invoked when a key has been typed
    public void keyTyped(KeyEvent e) {
    }

    @Override
    //invoked when a key has been pressed
    public void keyPressed(KeyEvent e) {
        //ret integer keyCode associated with the key in this event
        //ASCII ** 9 -> tab, 16 -> shift
        int code = e.getKeyCode();

        //event which indicates that a keystroke occurred
        if(code == KeyEvent.VK_W){ //constant for key w
            up = true;
        }

        if(code == KeyEvent.VK_A){
            left = true;
        }


        if(code == KeyEvent.VK_S){
            down = true;
        }


        if(code == KeyEvent.VK_D){
            right = true;
        }
    }






    @Override
    //invoked when a key has been released
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        //event which indicates that a keystroke occurred
        //set as false because key is released
        if(code == KeyEvent.VK_W){ //constant for key w
            up = false;
        }

        if(code == KeyEvent.VK_A){
            left = false;
        }


        if(code == KeyEvent.VK_S){
            down = false;
        }


        if(code == KeyEvent.VK_D){
            right = false;
        }

    }

    }
    

