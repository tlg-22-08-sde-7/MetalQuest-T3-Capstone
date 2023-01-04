package com.gui;

import com.metalquest.controller.GUIControllerPane;
import com.metalquest.model.Player;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class GameplayPane extends JPanel{


    private Room room;
    private Item item;
    private JLayeredPane jLayeredPane;
    Player player = Player.getPlayer();
    private final Border border = BorderFactory.createLineBorder(Color.red, 3);
    private int frameWidth;
    private int frameHeight;
    private String gameTitle;
    private int xValue;
    private int yValue;



    public GameplayPane(){
        this.setOpaque(true);
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        jLayeredPane = new JLayeredPane();
        room = new Room();
        room.setBounds(0,0,525,300);
        addRoomItems();

        jLayeredPane.add(room,Integer.valueOf(0));

        add(jLayeredPane);

    }

    public void addRoomItems(){

        Iterator it =player.getLocation().getItems().iterator();

            while (it.hasNext()){
                String itemName = (String)it.next();

            switch (itemName){
                case "guitar":
                    item = new Item(itemName,100,50);
                    jLayeredPane.add(item,Integer.valueOf(1));
                    break;
                case "cellphone":
                    item = new Item(itemName,225,228);
                    jLayeredPane.add(item,Integer.valueOf(1));
                    break;
                case "rolex":
                    item = new Item(itemName,245,220);
                    jLayeredPane.add(item,Integer.valueOf(1));
                    break;
            }
        }
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

