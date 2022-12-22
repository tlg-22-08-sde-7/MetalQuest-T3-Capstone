package com.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class DirectionsPane extends JPanel {

    private final Border border = BorderFactory.createLineBorder(Color.red, 3);

    public DirectionsPane () {
        init();
    }

    private void init() {
        this.setBackground(Color.ORANGE);
        this.setBorder(border);
    }
}
