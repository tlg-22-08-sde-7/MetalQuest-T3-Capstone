package com.gui;

import com.metalquest.model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Item extends JLabel implements MouseListener {

    BufferedImage img = null;
    private int imgWidth ;
    private int imgHeight ;
    private String nameOfItem;
    Player player = Player.getPlayer();


    public Item (String itemName, int x, int y){
        setNameOfItem(itemName);
        readItemImage(itemName);
        setBounds(x,y,getImgWidth(),getImgHeight());
        addMouseListener(this);
        setToolTipText("Click this Item to add it to inventory.");

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
        String filePath = "resources/images/"+ item +".png";
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

    @Override
    public void mouseClicked(MouseEvent e) {
        e.getComponent().setVisible(false);
        player.getItem(player,getNameOfItem());
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