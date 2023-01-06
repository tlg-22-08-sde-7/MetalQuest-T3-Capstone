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
import java.util.List;

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
    public void enterRoom(){
        removeRoomItems();
        addRoomItems();
    }

    public void addRoomItems(){
        List<String> inventory = player.getInventory();
        Iterator it =player.getLocation().getItems().iterator();

            while (it.hasNext()){
                String itemName = (String)it.next();

                if (inventory.contains(itemName)){
                    System.out.println(itemName + " has been collected from this room.");
                }
                else {
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
                        case "beer":
                            item = new Item(itemName,435,133);
                            jLayeredPane.add(item,Integer.valueOf(1));
                            break;
                        case "oj":
                            item = new Item(itemName,210,132);
                            jLayeredPane.add(item,Integer.valueOf(1));
                            break;
                        case "purplestuff":
                            item = new Item(itemName,145,145);
                            jLayeredPane.add(item,Integer.valueOf(1));
                            break;
                        case "water":
                            item = new Item(itemName,340,85);
                            jLayeredPane.add(item,Integer.valueOf(1));
                            break;
                        case "guitar picks":
                            item = new Item(itemName,120,75);
                            jLayeredPane.add(item,Integer.valueOf(1));
                            break;
                        case "music book":
                            item = new Item(itemName,25,215);
                            jLayeredPane.add(item,Integer.valueOf(1));
                            break;
                        case "shed":
                            item = new Item(itemName,290,157);
                            jLayeredPane.add(item,Integer.valueOf(1));
                            break;
                        case "wallet":
                            item = new Item(itemName,50,210);
                            jLayeredPane.add(item,Integer.valueOf(1));
                            break;
                        case "motorcycle":
                            item = new Item(itemName,275,120);
                            jLayeredPane.add(item,Integer.valueOf(1));
                            break;
                        case "brush":
                            item = new Item(itemName,40,110);
                            jLayeredPane.add(item,Integer.valueOf(1));
                            break;
                        case "cologne":
                            item = new Item(itemName,160,100);
                            jLayeredPane.add(item,Integer.valueOf(1));
                            break;
                        case "jalopy":
                            item = new Item(itemName,225,185);
                            jLayeredPane.add(item,Integer.valueOf(1));
                            break;
                    }
                }

        }
    }

    public void removeRoomItems(){
        Iterator it = Arrays.stream(jLayeredPane.getComponentsInLayer(1)).iterator();
        while (it.hasNext()){
            JLabel item = (JLabel)it.next();
            jLayeredPane.remove(item);
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

