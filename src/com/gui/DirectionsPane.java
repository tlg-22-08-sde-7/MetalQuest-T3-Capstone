package com.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;


public class DirectionsPane extends JPanel {

   // private final JLabel dir = new JLabel("Directions");

    public DirectionsPane() {
        init();
//        this.add(dir);
//        dir.setVerticalAlignment(JLabel.CENTER);
//        dir.setHorizontalAlignment(JLabel.CENTER);
        this.setLayout(new GridBagLayout());


    }

    private void init() {
        this.setBackground(Color.ORANGE);

        JLabel arrows = new JLabel();
        ImageIcon arrowsIcon = new ImageIcon("MetalQuest-T3-Capstone/resources/images/arrows.png");
        arrows.setOpaque(true);
        arrows.setHorizontalAlignment(JLabel.CENTER);
        arrows.setVerticalAlignment(JLabel.BOTTOM);

        arrowsIcon.setImage(arrowsIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        this.add(new JLabel(arrowsIcon));

    }
}

