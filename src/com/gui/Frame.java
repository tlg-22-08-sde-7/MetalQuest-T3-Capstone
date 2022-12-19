package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Frame {

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("MetalQuest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("METAL QUEST");
        label.setPreferredSize(new Dimension(700, 600));
        label.setForeground(Color.white);

        Font titleFont = new Font("Times New Roman", Font.BOLD, 90);
        label.setFont(titleFont);

        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.getContentPane().setBackground(Color.black);
        frame.pack();
        frame.setVisible(true);


        // set binding
        int condition = JPanel.WHEN_IN_FOCUSED_WINDOW;
        InputMap inputMap = ((JPanel) frame.getContentPane()).getInputMap(condition);
        ActionMap actionMap = ((JPanel) frame.getContentPane()).getActionMap();
        String enter = "enter";
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), enter);
        actionMap.put(enter, new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
    });
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
    }
