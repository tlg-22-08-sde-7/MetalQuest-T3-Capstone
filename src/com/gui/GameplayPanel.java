package com.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GameplayPanel extends JPanel{

    private final Border border = BorderFactory.createLineBorder(Color.red, 3);
    private int frameWidth;
    private int frameHeight;
    private String gameTitle;
    private int xValue;
    private int yValue;

    public GameplayPanel(String title, int x, int y, int width, int height) {
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
        this.setBackground(Color.GREEN);
        this.setLayout(null);
        this.setBorder(border);
    }

    public int getFrameWidth() {
        return frameWidth;
    }

    public void setFrameWidth(int frameWidth) {
        this.frameWidth = frameWidth;
    }

    public int getFrameHeight() {
        return frameHeight;
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

