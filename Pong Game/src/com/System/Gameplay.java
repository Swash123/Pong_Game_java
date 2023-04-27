package com.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gameplay extends JPanel implements ActionListener, KeyListener {

    boolean play=false;
    Timer timer;
    int delay=8;

    int paddleY1=210;
    int paddleY2=210;


    int ballPosX=380;
    int ballPosY=250;
    int ballDirX=3;
    int ballDirY=-3;

   Gameplay(){
       addKeyListener(this);
       setFocusable(true);
       setFocusTraversalKeysEnabled(false);
       timer=new Timer(8,this);
       timer.start();


   }



    @Override
    public void actionPerformed(ActionEvent e) {

       timer.start();
       if(play){

           if (new Rectangle(ballPosX,ballPosY,20,20).intersects(new Rectangle(1,1,783,3))||
                   new Rectangle(ballPosX,ballPosY,20,20).intersects(new Rectangle(1,460,783,3))){
               ballDirY=-ballDirY;
           }

           if(new Rectangle(ballPosX,ballPosY,20,20).intersects(new Rectangle(10,paddleY1,8,100))||
                   new Rectangle(ballPosX,ballPosY,20,20).intersects(new Rectangle(770,paddleY2,8,100))){
               ballDirX=-ballDirX;
           }

           if(ballPosX<-19){
               play=false;

               Window.player1Win++;
               Window.lblPlayer1.setText("Player 1 : "+Window.player1Win);

               JOptionPane.showMessageDialog(this,"hahaha noop can't even use bug to win");
               ballPosX=380;
               ballPosY=250;
               ballDirX=3;
               ballDirY=-3;


           }

           if(ballPosX>785){
               play=false;

               Window.player2Win++;
               Window.lblPlayer2.setText("Player 1 : "+Window.player2Win);

               JOptionPane.showMessageDialog(this,"hahaha noop can't even use bug to win");
               ballPosX=380;
               ballPosY=250;
               ballDirX=3;
               ballDirY=-3;


           }



           ballPosX+=ballDirX;
           ballPosY+=ballDirY;

       }
       repaint();
    }


    @Override
    public void paint(Graphics g) {

        //bg
        g.setColor(Color.BLACK);
        g.fillRect(0,0,786,550);


        //walls
        g.setColor(Color.BLUE);
        g.fillRect(1,1,783,3);
        g.fillRect(1,460,783,3);


        //paddle1
        g.setColor(Color.GREEN);
        g.fillRect(10,paddleY1,8,100);

        //paddle2
        g.setColor(Color.GREEN);
        g.fillRect(770,paddleY2,8,100);


        //ball
        g.setColor(Color.YELLOW);
        g.fillOval(ballPosX,ballPosY,20,20);


        g.dispose();

    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_S){

            if(paddleY1>=372){
                paddleY1=372;
            }else{
                move1Down();
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_W){

            if(paddleY1<=0){
                paddleY1=0;
            }else{
                move1Up();
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){

            if(paddleY2>=372){
                paddleY2=372;
            }else{
                move2Down();
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_UP){

            if(paddleY2<=0){
                paddleY2=0;
            }else{
                move2Up();
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    private void move1Down() {
        play=true;
        paddleY1+=20;
    }

    private void move1Up() {
        play=true;
        paddleY1-=20;
    }
    private void move2Down() {
        play=true;
        paddleY2+=20;
    }

    private void move2Up() {
        play=true;
        paddleY2-=20;
    }
}
