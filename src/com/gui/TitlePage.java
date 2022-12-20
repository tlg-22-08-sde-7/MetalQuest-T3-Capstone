package com.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

class TitlePage extends JFrame {

    TitlePage() {
        this.setTitle("Metal Quest");
        this.setSize(700, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits app
        this.setResizable(false); // prevents frame from
        this.setVisible(true); //make frame visible

        ImageIcon image = new ImageIcon("C:\\StudentWork\\MetalQuest\\MetalQuest-T3-Capstone\\resources\\images\\rockstar.png"); // creates Image Icon
        this.setIconImage(image.getImage()); // change icon of frame
        this.getContentPane().setBackground(Color.black); // change color of background

        ImageIcon logo = new ImageIcon("C:\\StudentWork\\MetalQuest\\MetalQuest-T3-Capstone\\resources\\images\\rockstar.png");
        Border border = BorderFactory.createLineBorder(Color.red, 3);

        JLabel label = new JLabel("METAL QUEST"); // creates label & sets text
        this.add(label);
        label.setIcon(logo);
        label.setHorizontalTextPosition(JLabel.CENTER); //set text CENTER of image icon
        label.setVerticalTextPosition(JLabel.TOP); // set text TOP of image
        label.setForeground(Color.red); // changes font color
        label.setFont(new Font("Serif", Font.BOLD, 40)); // set font of text
        label.setIconTextGap(-20); // set gap of text to image
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER); // set vertical position of icon + text
        label.setHorizontalAlignment(JLabel.CENTER); // set horizontal position within label

        // set binding
        int condition = JPanel.WHEN_IN_FOCUSED_WINDOW;
        InputMap inputMap = ((JPanel) this.getContentPane()).getInputMap(condition);
        ActionMap actionMap = ((JPanel) this.getContentPane()).getActionMap();
        String enter = "enter";
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), enter);
        actionMap.put(enter, new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
