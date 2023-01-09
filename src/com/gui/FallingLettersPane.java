package com.gui;

import com.metalquest.model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class FallingLettersPane extends JPanel {
    private static final List<Box> boxes = new ArrayList<>(25);
    private static final int[] perfectBounds = new int[]{75, 85};
    private final SuccessArea successArea = new SuccessArea(Color.GREEN, new Dimension(this.getWidth(), 25));
    private static final int targetAreaY = 375;
    private static final int targetAreaHeight = 40;
    private static final int perfectPoints = 30;
    private static final int correctPoints = 15;
    public static final int incorrectPoints = 15;

    public FallingLettersPane() {

        /*
         TODO:
          - Add an area that shows the player's score
          - Prettify the game
         */
        Color[] colors = {Color.RED, Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.WHITE, Color.YELLOW};
        this.setSize(500, 500);
        this.setLayout(new GridBagLayout());
        this.setVisible(true); //make frame visible

        for (int index = 0; index < 1; index++) {
            Color color = colors[(int) (Math.random() * colors.length)];
            int width = 10 + (int) (Math.random() * 9);
            int height = 10 + (int) (Math.random() * 9);
            boxes.add(new PlayerLetterColumn1(color, new Dimension(width, height)));
            boxes.add(new PlayerLetterColumn2(color, new Dimension(width, height)));
            boxes.add(new PlayerLetterColumn3(color, new Dimension(width, height)));
            boxes.add(new PlayerLetterColumn4(color, new Dimension(width, height)));
            boxes.add(new PlayerLetterColumn5(color, new Dimension(width, height)));
        }

        Timer timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Box box : boxes) {
                    box.update(getSize());
                }
                repaint();
            }
        });
        timer.start();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(0, targetAreaY, getWidth(), 20);
        g.setColor(Color.BLACK);
        for (Box box : boxes) {
            Graphics2D g2d = (Graphics2D) g.create();
            box.paint(g2d);
            g2d.dispose();
        }

    }

    /* TODO:
        - Update player's "fame" or score based on whether they've selected the right key
        - Update bounds so that players can earn partial credit if letter is somewhat in area
     */
    public static void checkKey(String key) {
        for (Box box : boxes) {
            if (box.isActive()) {
                if (targetAreaY - 20 <= box.getY() && targetAreaY + targetAreaHeight + 20 >= box.getY()) {
                    if (targetAreaY <= box.getY() && targetAreaY + targetAreaHeight >= box.getY()) {
                        if (box.getKey().equalsIgnoreCase(key)) {
                            Player.getPlayer().setFame(Player.getPlayer().getFame() + perfectPoints);
                            box.setFound();
                            System.out.println("Perfect! Your fame is: " + Player.getPlayer().getFame());
                        }
                    } else {
                        if (box.getKey().equalsIgnoreCase(key)) {
                            Player.getPlayer().setFame(Player.getPlayer().getFame() + correctPoints);
                            System.out.println("Close Enough! Your fame is: " + Player.getPlayer().getFame());
                        }
                    }
                }
            }
        }
    }
}
