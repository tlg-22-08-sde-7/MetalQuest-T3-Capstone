package com.gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;

public class MenuBar extends JFrame implements ActionListener{
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu volumeMenu;
    JMenu helpMenu;
    JMenuItem loadItem;
    JMenuItem saveItem;
    JMenuItem exitItem;

    MenuBar() {

        this.setSize(500, 500);
        this.setLayout(new FlowLayout());
        this.setVisible(true);

        menuBar = new JMenuBar();

        fileMenu = new JMenu("File");
        volumeMenu = new JMenu("Volume");
        helpMenu = new JMenu("Help");

        loadItem = new JMenuItem("Load");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        loadItem.addActionListener((ActionListener) this);
        saveItem.addActionListener((ActionListener) this);
        exitItem.addActionListener((ActionListener) this);

        fileMenu.setMnemonic(KeyEvent.VK_F); // Alt + f for file
        volumeMenu.setMnemonic(KeyEvent.VK_E); // Alt + e for edit
        helpMenu.setMnemonic(KeyEvent.VK_H); // Alt + h for help
        loadItem.setMnemonic(KeyEvent.VK_L); // l for load
        saveItem.setMnemonic(KeyEvent.VK_S); // s for save
        exitItem.setMnemonic(KeyEvent.VK_E); // e for exit

        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        menuBar.add(volumeMenu);
        menuBar.add(helpMenu);

        this.setJMenuBar(menuBar);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==loadItem) {
            System.out.println("*beep boop* you loaded a file");
        }
        if(e.getSource()==saveItem) {
            System.out.println("*beep boop* you saved a file");
        }
        if(e.getSource()==exitItem) {
            System.exit(0);
        }
    }
}