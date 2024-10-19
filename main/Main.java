package main;


import javax.swing.JFrame;


public class Main{ 
    public static void main(String[] args){

        //constructs a new frame that is initially invisible.
        JFrame window = new JFrame();

        //sets whether this frame is resizable by user.
        window.setResizable(false);
        window.setTitle("Reality Surf");


        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);



        //causes window to be sized to fit the preferred size of subcomponents
        window.pack();

        //sets location of window relative to  specified component
        window.setLocationRelativeTo(null);

        //shows or hides this window depending on value of parameter
        window.setVisible(true);


        //START THE THREAD!!
        gamePanel.startGameThread();

}

}