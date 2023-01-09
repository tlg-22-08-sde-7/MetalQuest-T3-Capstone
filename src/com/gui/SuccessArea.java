package com.gui;

import java.awt.*;

public class SuccessArea {
    private Color color;
    private Rectangle bounds;

    public SuccessArea(Color color, Dimension size) {
        this.color = color;
        bounds = new Rectangle(new Point(0, 20), size);
    }

    public void paint(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fill(bounds);
    }
}
