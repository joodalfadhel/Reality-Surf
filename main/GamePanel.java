package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;



public class GamePanel extends JPanel implements Runnable{
    
    //Screen Settings
    final int originalTileSize = 16;

    final int scale = 3; 

    final int tileSize = originalTileSize * scale; 

    final int maxScreenCol = 16; 
    final int maxScreenRow = 12; 


    final int screenWidth = tileSize * maxScreenCol; 
    final int screenHeight = tileSize * maxScreenRow;


    //FPS
    int FPS = 60;


    //Imp
    KeyHandler key = new KeyHandler();
    Thread gameThread; //once thread started keeps it running


    //A Player's Default Positions 
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;



    public GamePanel(){
        //set pref size -> construct dimension and initializes it width and height
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.green);

        //sets whether component should use a buffer to paint. If true, all drawings from component will be done in an offscreen painting buffer
        this.setDoubleBuffered(true);
        this.addKeyListener(key); //add keylistener 
       
        //sets focusable state of component specified value
        this.setFocusable(true);

    }




    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }





    public void run(){

        while(gameThread != null){

            //getting time so it can be controlled for movement, 60 fps
            //nanotiem returns current value of running jvm time source
            long currentTime = System.nanoTime();


            //System.out.println("muhahahahahhahahahah the game is running  ");
            //update:
            update();

            //draw:
            repaint();
        }

    }  






    // Update: update info such as char positions
    //upper left corner is x:0 , y:0
    //playerSpeed = 4 -> move 4 pixels
    public void update() {
        if(key.up == true){ 
            playerY = playerY - playerSpeed; //subtracting speed from y, y val decreases if going up, means move 4 pixels
        }
        else if (key.down == true){
            playerY = playerY + playerSpeed; //adding speed to y, y val increases if going down
        }
        else if (key.left == true){
            playerX = playerX - playerSpeed; //subtracting speed from x, x val decreases if going left
        }
        else if (key.right == true){
            playerX = playerX + playerSpeed; //adding speed from x, x val increases if going left
        }
    }







    // Draw: draw the screen w updated info 
    public void paintComponent(Graphics g){

        //Callss paint method, if non-null
        super.paintComponent(g);


        //Graphics2D class extends Graphics class to provide more  control -> geometry, coordinates..
        Graphics2D g2 = (Graphics2D)g;
        //set graphics g to graphics 2d


        //Sets this graphics context's current color to the specified color
        g2.setColor(Color.pink);

        //fills rectangle
        //left and right edges of it are at x and x + width - 1
        //top and bottom edges are at y and y + height - 1.
        //player x and y -> x and y pos of player
        g2.fillRect(playerX, playerY, tileSize, tileSize);
       
        //Disposes of graphics context 
        g2.dispose();
    }



}
