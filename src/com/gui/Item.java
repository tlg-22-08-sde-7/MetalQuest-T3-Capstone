package com.gui;

import com.metalquest.model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Item extends JLabel implements MouseListener {

    BufferedImage img = null;
    private int imgWidth ;
    private int imgHeight ;
    private String nameOfItem;
    private List<String> completedInventoryList = new ArrayList<>();
    Player player = Player.getPlayer();
    DescriptionPane descriptionPane = DescriptionPane.getInstance();


    public Item (String itemName, int x, int y){
        setNameOfItem(itemName);
        readItemImage(itemName);
        setBounds(x,y,getImgWidth(),getImgHeight());
        addMouseListener(this);

        if(getNameOfItem().equals("shed")){
            setToolTipText("Click this item to look inside.");
        }else if (getNameOfItem().equals("motorcycle")){
            setToolTipText("Click this item to leave and head to concert. ");
        }else {
            setToolTipText("Click this Item to add it to inventory.");
        }


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(getImg(), 0, 0, getImgWidth(), getImgHeight(), this);
        repaint();
        revalidate();
    }


    /*
     * Use if decide to use sprite sheet.
     *
     *public BufferedImage getItemSprite(String item){
     *   String filePath = "resources/images/"+ item +"_spritesheet.png";
     *    ImageLoader loader = new ImageLoader();
     *    BufferedImage spriteSheet = null;
     *    BufferedImage sprite = null;
     *    try {
     *        spriteSheet = loader.loadImage(filePath);
     *    } catch (IOException e) {
     *        e.printStackTrace();
     *    }
     *    SpriteSheet ss = new SpriteSheet(spriteSheet);
     *    return sprite = ss.grabSprite(0,0,20,15);
     *}
     */


    public void readItemImage(String item){
        String filePath = "resources/images/"+item+".png";
        ImageLoader loader = new ImageLoader();
        try {
            img = loader.loadImage(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        img.getScaledInstance(getImgWidth(),getImgHeight(),Image.SCALE_SMOOTH);
        setImg(img);
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public Integer getImgWidth() {
        imgWidth = (img.getWidth()/10);
        return imgWidth;
    }

    public Integer getImgHeight() {
        imgHeight = (img.getHeight()/10);
        return imgHeight;
    }

    public String getNameOfItem() {
        return nameOfItem;
    }

    public void setNameOfItem(String nameOfItem) {
        this.nameOfItem = nameOfItem;
    }

    public List<String> getCompletedInventoryList() {
        completedInventoryList.add("guitar");
        completedInventoryList.add("rolex");
        completedInventoryList.add("cellphone");
        completedInventoryList.add("wallet");
        completedInventoryList.add("music book");
        completedInventoryList.add("guitar picks");
        completedInventoryList.add("water");
        return completedInventoryList;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (getNameOfItem().equals("shed")){
            descriptionPane.setLabelText("You looked inside the Shed and see spider webs and parts for your jalopy.");
        } else if (getNameOfItem().equals("motorcycle")){
            if (player.getInventory().containsAll(getCompletedInventoryList()) ){
                descriptionPane.setLabelText("You have collected all your items needed to have a great performance tonight" +
                        " at the house of blues. You are ready tp hop on your motorcycle and head to the concert. Double click the motorcycle to head to concert.");
                if (e.getClickCount() == 2){
                    player.setLocation("Concert");
                    e.getComponent().setVisible(false);


                }
            }else {
                descriptionPane.setLabelText("You have not gotten all the items need to have a good performance.");
            }
        }else if (getNameOfItem().equals("jalopy")){
            descriptionPane.setLabelText("You try to start the engine but the jalopy does not run. Please choose another means of transportation.");
        }
        else {
            e.getComponent().setVisible(false);
            player.getItem(player,getNameOfItem());
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}