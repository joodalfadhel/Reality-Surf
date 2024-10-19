package main;


import javax.swing.JFrame;


public class Main{ 
    public static void main(String[] args){
        JFrame window = new JFrame();
        window.setResizable(false);
        window.setTitle("Reality Surf");


        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);


        window.pack();

        window.setLocationRelativeTo(null);

        window.setVisible(true);

        gamePanel.startGameThread();

}

}