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

    Player player = Player.getPlayer();

    private BufferedImage currentRoomImage;
    private final Border border = BorderFactory.createLineBorder(Color.red, 3);
    private int frameWidth;
    private int frameHeight;
    private String gameTitle;
    private int xValue;
    private int yValue;



    public GameplayPane(){
        //this.add(createItem("guitar"));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(getCurrentRoomImage(), 0, 0, 525, 300, this);
        repaint();
        revalidate();
    }

    public JLabel createItem(String itemName){
        JLabel item = new JLabel();

        ImageIcon imageIcon = new ImageIcon(getItemImage(itemName));
        item.setIcon(imageIcon);
        item.setBounds(0,0,25,25);
        return item;
    }

//   public void renderItem(){
//       JLabel itemLabel = createItem("guitar");
//       itemLabel.setBounds(175,275,100,75);
//       this.add(itemLabel);
////       for (Object item:player.getLocation().getItems()) {
////           JLabel itemLabel = createItem((String) item);
////           itemLabel.setBounds(175,275,100,75);
////           this.add(itemLabel);
////       }
//   }





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

