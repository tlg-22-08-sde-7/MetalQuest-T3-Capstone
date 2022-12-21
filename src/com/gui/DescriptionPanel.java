package com.gui;

import com.metalquest.model.LocationsEnum;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class DescriptionPanel extends JPanel {

    private final Border border = BorderFactory.createLineBorder(Color.red, 3);
    private JLabel label = new JLabel("This is some text.");
    private int frameWidth;
    private int frameHeight;
    private String gameTitle;
    private int xValue;
    private int yValue;

    public DescriptionPanel(String title, int x, int y, int width, int height) {
        // Set properties
//        setFrameHeight(height);
//        setFrameWidth(width);
//        setGameTitle(title);
//        setxValue(x);
//        setyValue(y);

        // Initialize
        init();
    }

    public void describe(LocationsEnum location) {
        switch (location) {
            case LIVING_ROOM:
                // living rooom
                break;
            case KITCHEN:
                // kitchen
                label.setText("In the kitchen");
                break;
            case BACKYARD:
                // backyard
                break;
            case MASTER_BEDROOM:
                // master bedroom
                break;
            case BATHROOM:
                // bathroom
                break;
            case GARAGE:
                // garage
                break;
        }
    }

    private void init() {
       // this.setBounds(getxValue(), getyValue(), getFrameWidth(), getFrameHeight());
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(border);

        createLabel();

        this.add(label);
        this.revalidate();
        this.repaint();
    }

    private void createLabel() {

        label.setSize(label.getPreferredSize());
        label.setLocation(20, 675);

        this.repaint();
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
