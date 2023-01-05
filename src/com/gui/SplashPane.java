package com.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class SplashPane extends JPanel {

    private final JLabel label = new JLabel();
    private final Border border = BorderFactory.createLineBorder(Color.red, 3);
    private final ImageIcon logo = new ImageIcon("resources/images/MetalQuest.gif");
    private int frameWidth;
    private int frameHeight;
    //private String gameTitle;
    private int xValue;
    private int yValue;


    public SplashPane(String title, int x, int y, int width, int height) {
        //setGameTitle(title);

        init();

        setLayout(new GridLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        // Add Label
        createLabel();

        this.add(label, gbc);
    }

    private void init() {
        this.setBounds(getxValue(), getyValue(), getFrameWidth(), getFrameHeight());
        this.setBackground(Color.BLACK);
        this.setBorder(border);
    }

    private void createLabel() {
        label.setBounds(0, 0, getFrameWidth(), getFrameHeight());
        label.setIcon(logo);
        label.setHorizontalTextPosition(JLabel.CENTER); //set text CENTER of image icon
        label.setVerticalTextPosition(JLabel.TOP); // set text TOP of image
        label.setForeground(Color.red); // changes font color
        //label.setFont(new Font("Serif", Font.BOLD, 40)); // set font of text
        label.setIconTextGap(-20); // set gap of text to image
        label.setVerticalAlignment(JLabel.CENTER); // set vertical position of icon + text
        label.setHorizontalAlignment(JLabel.CENTER); // set horizontal position within label
        //label.setText(getGameTitle());
    }

    // Getters and Setters
    public int getFrameWidth() {
        return frameWidth;
    }

    public int getFrameHeight() {
        return frameHeight;
    }

    public void setFrameWidth(int frameWidth) {
        this.frameWidth = frameWidth;
    }

    public void setFrameHeight(int frameHeight) {
        this.frameHeight = frameHeight;
    }
//
//    public String getGameTitle() {
//        return gameTitle;
//    }
//
//    public void setGameTitle(String gameTitle) {
//        this.gameTitle = gameTitle;
//    }

    public int getxValue() {
        return xValue;
    }

    public void setxValue(int xValue) {
        this.xValue = xValue;
    }

    public int getyValue() {
        return yValue;
    }

    public void setyValue(int yValue) {
        this.yValue = yValue;
    }
}
