package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import sprites.Player;



public class GamePanel extends JPanel implements Runnable{
    
    //Screen Settings
    final int originalTileSize = 16;

    final int scale = 3; 

    public final int tileSize = originalTileSize * scale; 

    final int maxScreenCol = 16; 
    final int maxScreenRow = 12; 


    final int screenWidth = tileSize * maxScreenCol; 
    final int screenHeight = tileSize * maxScreenRow;


    //FPS
    int FPS = 60;


    //Imp
    KeyHandler key = new KeyHandler();
    Thread gameThread; //once thread started keeps it running
    Player player = new Player(this,key);


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

        //delta/acumlator method: 
        double drawinterval = 1000000000/FPS;
        double delta = 0; 
        long lastTime = System.nanoTime();
        long currentTime;

        //check fps
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null){

            currentTime = System.nanoTime(); //check current time 

            delta += (currentTime - lastTime) / drawinterval; //subtract current time from last time (checking how much time has passed)
            //every loop adds lastime div by drawinterval to delta

            timer += (currentTime - lastTime);


            lastTime = currentTime;


            if(delta >= 1){ //when delta reaches drawinterval -> update and repaint
            //update:
            update();

            //draw:
            repaint();

            delta--;
            drawCount++;
            }

            if(timer >= 1000000000){
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }

        }
        

        /* 
         //sleep method 

        double drawInterval = 1000000000/FPS;   //1 second = 1 billion nanoseconds -> 16 -> draw the screen every 0.01667 nanoseconds = 60 times per second
        double nextDrawTime = System.nanoTime() + drawInterval; //the alloc time for the loop is 0.016 sec
        //after alloc time -> game loop starts 


        while(gameThread != null){

            //getting time so it can be controlled for movement, 60 fps
            //nanotiem returns current value of running jvm time source
            //long currentTime = System.nanoTime();
            //System.out.println("muhahahahahhahahahah the game is running  ");



            //update:
            update();

            //draw:
            repaint();


           

            try {
                 //check how much time left 
                double RemainingDrawTime = nextDrawTime - System.nanoTime(); //how much time remaining till end 

                RemainingDrawTime = RemainingDrawTime/ 1000000 ; //done in milli -> must convert from nano to milli seconds 
                
                   
                if(RemainingDrawTime < 0){
                    RemainingDrawTime = 0; 
                }
 

                Thread.sleep((long) RemainingDrawTime);
                nextDrawTime += drawInterval;
             
            } catch (InterruptedException e) {
                e.printStackTrace();

            } 
            

        }
        */
    }  
       

    





    // Update: update info such as char positions
    //upper left corner is x:0 , y:0
    //playerSpeed = 4 -> move 4 pixels
    public void update() {
        player.update();
    }







    // Draw: draw the screen w updated info 
    public void paintComponent(Graphics g){

        //Callss paint method, if non-null
        super.paintComponent(g);


        //Graphics2D class extends Graphics class to provide more  control -> geometry, coordinates..
        Graphics2D g2 = (Graphics2D)g;
        //set graphics g to graphics 2d

        player.draw(g2);

        //Disposes of graphics context 
        g2.dispose();
    }



}
