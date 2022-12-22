package com.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class InventoryPane extends JPanel {

    private final Border border = BorderFactory.createLineBorder(Color.red, 3);

    public InventoryPane() {
        init();
    }

    private void init() {
        // TODO: remove this
        this.setBackground(Color.RED);
        this.setBorder(border);
        // once functionality is set up
    }
}