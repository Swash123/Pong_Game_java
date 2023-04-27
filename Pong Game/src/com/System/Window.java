package com.System;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    Gameplay gameplay;
    JPanel pnlTitle;

    static JLabel lblPlayer1;
    static JLabel lblPlayer2;
    static int player1Win=0;
    static int player2Win=0;

    Window(){
        gameplay=new Gameplay();
        pnlTitle = new JPanel();

        lblPlayer1 =new JLabel();
        lblPlayer2= new JLabel();

        lblPlayer1.setText("Player 1 : "+player1Win);
        lblPlayer1.setPreferredSize(new Dimension(80,33));
        lblPlayer1.setForeground(Color.WHITE);
        lblPlayer1.setHorizontalAlignment(JLabel.LEFT);

        lblPlayer2.setText("Player 2 : "+ player2Win);
        lblPlayer2.setPreferredSize(new Dimension(80,33));
        lblPlayer2.setForeground(Color.WHITE);
        lblPlayer2.setHorizontalAlignment(JLabel.RIGHT);



        pnlTitle.setLayout(new BorderLayout());
        pnlTitle.setBounds(0,0,800,100);
        pnlTitle.add(lblPlayer1,BorderLayout.EAST);
        pnlTitle.add(lblPlayer2,BorderLayout.WEST);
        pnlTitle.setBackground(Color.BLACK);

        setLayout(new BorderLayout());
        add(gameplay,BorderLayout.CENTER);
        add(pnlTitle,BorderLayout.NORTH);
        setSize(800,533);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
