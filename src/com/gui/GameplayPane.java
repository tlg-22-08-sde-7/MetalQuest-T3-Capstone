package com.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GameplayPane extends JPanel{

    private final Border border = BorderFactory.createLineBorder(Color.red, 3);
    private int frameWidth;
    private int frameHeight;
    private String gameTitle;
    private int xValue;
    private int yValue;

    public GameplayPane() {
        // Initialize
        init();
    }

    private void init() {
        this.setBackground(Color.GREEN);
        this.setBorder(border);
    }


}

