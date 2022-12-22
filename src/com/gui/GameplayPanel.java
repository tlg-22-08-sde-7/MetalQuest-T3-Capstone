package com.gui;

import com.metalquest.model.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameplayPanel extends JPanel{

    Player player = Player.getPlayer();
    String room = player.getRoomLocation().getRoom();
    private BufferedImage currentRoomImage;
    private final Border border = BorderFactory.createLineBorder(Color.red, 3);
    private int frameWidth;
    private int frameHeight;
    private String gameTitle;
    private int xValue;
    private int yValue;


    private GameplayPanel(){

    }

    public GameplayPanel(String title, int x, int y, int width, int height) {
        // Set properties
//        setFrameHeight(height);
//        setFrameWidth(width);
//        setGameTitle(title);
//        setxValue(x);
//        setyValue(y);

        // Initialize
        init();
    }

    private void init() {
        //this.setBounds(getxValue(), getyValue(), getFrameWidth(), getFrameHeight());

        this.setBorder(border);

    }




    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(getCurrentRoomImage().getScaledInstance(574,310,Image.SCALE_DEFAULT), 0, 0, this);
    }
    public BufferedImage readCurrentRoomImage(String room){
        String filePath = "resources/images/"+ room +".jpg";
        if (room != null) {
            try {
                currentRoomImage = ImageIO.read(new File(filePath));
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        return currentRoomImage;
    }

    public BufferedImage getCurrentRoomImage() {
        return readCurrentRoomImage(player.getRoomLocation().getRoom());
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

