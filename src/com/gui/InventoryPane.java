package com.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class InventoryPane extends JPanel {

    private final Border border = BorderFactory.createLineBorder(Color.red, 3);
    private final DefaultListModel<String> playerInventory = new DefaultListModel<>();
    private final JList<String> playerInventoryList = new JList<>(playerInventory);

    public InventoryPane() {
        init();
    }

    private void init() {
        // TODO: remove this
        this.setLayout(new BorderLayout());
        this.setBackground(Color.RED);
        this.setBorder(border);
        this.add(playerInventoryList);
        // once functionality is set up
    }

    public void addItemToInventoryList(String item) {
        playerInventory.addElement(item);
    }
}