package com.gui;

import com.metalquest.controller.GUIControllerPane;
import com.metalquest.model.Player;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class GameplayPane extends JPanel{


    private Room room;
    private final Border border = BorderFactory.createLineBorder(Color.red, 3);
    private int frameWidth;
    private int frameHeight;
    private String gameTitle;
    private int xValue;
    private int yValue;



    public GameplayPane(){
        this.setOpaque(true);
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        JLayeredPane jLayeredPane = new JLayeredPane();
        room = new Room();
        room.setVerticalAlignment(JLabel.TOP);
        room.setHorizontalAlignment(JLabel.CENTER);
        room.setBounds(0,0,525,300);
        jLayeredPane.add(room,Integer.valueOf(0),0);
        add(jLayeredPane);

    }


    public JLabel createItem(String itemName){
        JLabel item = new JLabel();
        BufferedImage img = getItemImage(itemName);
        //img.getScaledInstance(100,75,Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(getItemImage(itemName));
        item.setIcon(imageIcon);
        //item.setSize(75,100);

        return item;
    }

    public BufferedImage getItemSprite(String item){
        String filePath = "resources/images/"+ item +"_spritesheet.png";
        ImageLoader loader = new ImageLoader();
        BufferedImage spriteSheet = null;
        BufferedImage sprite = null;
        try {
            spriteSheet = loader.loadImage(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SpriteSheet ss = new SpriteSheet(spriteSheet);
        return sprite = ss.grabSprite(0,0,20,15);
    }

    public BufferedImage getItemImage(String item){
        String filePath = "resources/images/"+ item +".png";
        ImageLoader loader = new ImageLoader();
        BufferedImage itemImage = null;
        try {
            itemImage = loader.loadImage(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemImage;
    }

    public int getFrameWidth() {
        return frameWidth;
    }

    public void setFrameWidth(int frameWidth) {
        this.frameWidth = frameWidth;
    }

    public int getFrameHeight() {
        return frameHeight;
    }

    public void setFrameHeight(int frameHeight) {
        this.frameHeight = frameHeight;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public int getxValue() {
        return xValue;
    }

    public void setxValue(int xValue) {
        this.xValue = xValue;
    }

    public int getyValue() {
        return yValue;
    }

    public void setyValue(int yValue) {
        this.yValue = yValue;
    }
}

