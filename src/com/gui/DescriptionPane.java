package com.gui;

import com.metalquest.model.LocationsEnum;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class DescriptionPane extends JPanel {

    private final Border border = BorderFactory.createLineBorder(Color.red, 3);
    private final JLabel label = new JLabel("This is some text.");
    private final JTextArea textArea = new JTextArea(7, 30);
    private static DescriptionPane descriptionPane = null;

    private DescriptionPane() {
        init();
    }

    public static DescriptionPane getInstance(){
        if (descriptionPane == null){
            descriptionPane = new DescriptionPane();
        }
        return descriptionPane;
    }

    private void init() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.BLACK);

        addTextArea();

        this.add(textArea);
        this.revalidate();
        this.repaint();
    }

    private void addTextArea() {
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
    }

    public void setLabelText(String text) {
        textArea.setText(text);

        this.repaint();
    }
}
