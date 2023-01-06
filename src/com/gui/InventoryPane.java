package com.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class InventoryPane extends JPanel {

    private static InventoryPane inventoryPane;
    private static Border border;
    private static DefaultListModel<String> playerInventory;
    private static JList<String> playerInventoryList;

    private InventoryPane() {}

    public static InventoryPane getInstance() {
        if (inventoryPane == null) {

            inventoryPane = new InventoryPane();

            init();
        }

        return inventoryPane;
    }

    private static void init() {
        border = BorderFactory.createLineBorder(Color.red, 3);

        playerInventory = new DefaultListModel<>();
        playerInventoryList = new JList<>(playerInventory);
        inventoryPane.setLayout(new BorderLayout());
        inventoryPane.setBackground(Color.RED);
        inventoryPane.setBorder(border);
        inventoryPane.add(playerInventoryList);

        // once functionality is set up
    }

    public void addItemToInventoryList(String item) {
        playerInventory.addElement(item);
    }
}