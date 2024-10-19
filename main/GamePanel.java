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


    Thread gameThread; //once thread started keeps it running




    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.green);
        this.setDoubleBuffered(true);

    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }


    public void run(){

        while(gameThread != null){
            //System.out.println("muhahahahahhahahahah the game is running  ");
            //update:
            update();

            //draw:
            repaint();
        }

    }  


    // Update: update info such as char positions
    public void update() {

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
        g2.fillRect(100, 100, tileSize, tileSize);
       
        //Disposes of graphics context 
        g2.dispose();
    }



}
