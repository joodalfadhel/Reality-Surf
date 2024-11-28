package sprites;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler key;

    public Player(GamePanel gp, KeyHandler key){
        this.gp = gp;
        this.key = key;

        setDefaultValues();
        getPlayerImage();
    }


    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";

    }
    
    public void getPlayerImage(){
        try{
            mc1 = ImageIO.read(getClass().getResourceAsStream("/imgs/player/dahom1.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if(key.up == true){ 
            direction = "up";
            y = y - speed; //subtracting speed from y, y val decreases if going up, means move 4 pixels
        }
        else if (key.down == true){
            direction = "down";
            y = y + speed; //adding speed to y, y val increases if going down
        }
        else if (key.left == true){
            direction = "left";
            x = x - speed; //subtracting speed from x, x val decreases if going left
        }
        else if (key.right == true){
            direction = "right";
            x = x + speed; //adding speed from x, x val increases if going left
        }


    }


    public void draw(Graphics2D g2){

    /* 
    //Sets this graphics context's current color to the specified color
    g2.setColor(Color.pink);

    //fills rectangle
    //left and right edges of it are at x and x + width - 1
    //top and bottom edges are at y and y + height - 1.
    //player x and y -> x and y pos of player
    g2.fillRect(x, y, gp.tileSize, gp.tileSize);
    */

    BufferedImage image = null;

    switch(direction){
    case "up": 
    image = mc1;
    break;


    case "down": 
    image = mc1;
    break;



    case "left": 
    image = mc1;
    break;

    case "right": 
    image = mc1;
    break;

    }

    g2.drawImage(image, x , y, gp.tileSize, gp.tileSize, null);

}

}
