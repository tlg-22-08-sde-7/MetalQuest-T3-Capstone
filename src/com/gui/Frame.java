package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Frame extends JFrame{
    private final String gameTitle = "Metal Quest";
    private final int frameWidth = 1200;
    private final int frameHeight = 1000;
    private final JPanel welcomePanel = new WelcomePanel(gameTitle, 0, 0, frameWidth, frameHeight);
    private final JPanel masterPanel = new MasterPanel(gameTitle, 0, 0, frameWidth, frameHeight);

    Frame() {
        init();
    }

    private void init() {
        this.setTitle(gameTitle);
        this.setSize(frameWidth, frameHeight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits app
        this.setResizable(false); // prevents frame from
        this.setVisible(true); //make frame visible
        this.setLayout(null);
        ImageIcon image = new ImageIcon("C:\\StudentWork\\MetalQuest\\MetalQuest-T3-Capstone\\resources\\images\\rockstar.png"); // creates Image Icon
        this.setIconImage(image.getImage()); // change icon of frame
        this.getContentPane().setBackground(Color.black); // change color of background

        // set binding
        Action removeAction = new RemoveAction();

        addWelcomePanel();

        masterPanel.getInputMap().put(KeyStroke.getKeyStroke("ESCAPE"), "removeAction");
        masterPanel.getActionMap().put("removeAction", removeAction);
    }

    private void addWelcomePanel() {
        masterPanel.add(welcomePanel);
        this.add(masterPanel);
    }

    public class RemoveAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            masterPanel.remove(welcomePanel);

            repaint();
        }
    }
}
