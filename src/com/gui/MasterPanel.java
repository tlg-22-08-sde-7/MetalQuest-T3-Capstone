package com.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MasterPanel extends JPanel {

    private final JLabel label = new JLabel();
    private final Border border = BorderFactory.createLineBorder(Color.red, 3);
    private final ImageIcon logo = new ImageIcon("C:\\StudentWork\\MetalQuest\\MetalQuest-T3-Capstone\\resources\\images\\rockstar.png");
    private int frameWidth;
    private int frameHeight;
    private String gameTitle;
    private int xValue;
    private int yValue;


    public MasterPanel(String title, int x, int y, int width, int height) {
        // Set properties
        setFrameHeight(height);
        setFrameWidth(width);
        setGameTitle(title);
        setxValue(x);
        setyValue(y);

        // Initialize
        init();
    }

    private void init() {
        this.setBounds(getxValue(), getyValue(), getFrameWidth(), getFrameHeight());
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        this.setBorder(border);
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

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

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
