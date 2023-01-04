package com.gui;

import com.metalquest.model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Room extends JLabel {
    Player player = Player.getPlayer();
    private BufferedImage currentRoomImage;

    public Room(){


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(getCurrentRoomImage(), 0, 0, 525, 300, this);
        repaint();
        revalidate();
    }

    public BufferedImage getCurrentRoomImage() {
        String room = player.getLocation().getRoom();
        String filePath = "resources/images/"+ room +".jpg";
        ImageLoader loader = new ImageLoader();
        if (room != null) {
            try {
                currentRoomImage = loader.loadImage(filePath);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return currentRoomImage;
    }


}