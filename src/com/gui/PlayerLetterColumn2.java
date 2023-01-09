package com.gui;

import com.metalquest.model.Player;

import java.awt.*;

public class PlayerLetterColumn2 extends Box {
    private Color color;
    private final Rectangle bounds;
    private final int textHeight = 25;
    public boolean active = true;
    private boolean found = false;
    private int remainingRounds = 5;

    private String key;
    private int randomDelta;


    public PlayerLetterColumn2(Color color, Dimension size) {
        bounds = new Rectangle(new Point(125, 0), size);

        setKey();
        setRandomDelta();
    }

    private void resetSquare() {
        bounds.y = 0;
        this.active = true;
        this.found = false;

        setKey();
        setRandomDelta();
    }

    @Override
    public void update(Dimension size) {
        bounds.y += randomDelta;

        if ((bounds.y / 2) + textHeight > size.height) {
            if (this.active) {
                endActive();

                if (!this.found) {
                    Player.getPlayer().setFame(Player.getPlayer().getFame() - FallingLettersPane.incorrectPoints);
                    System.out.println("Player points: " + Player.getPlayer().getFame());
                }

                if (--remainingRounds >= 0) {
                    resetSquare();
                }
                else {
                    endGame();
                }
            }
        }
    }

    private void endGame() {
        Frame.getInstance().endGame();
    }

    @Override
    public void paint(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.setFont(new Font(g2d.getFont().getFontName(), Font.BOLD, textHeight));
        g2d.drawString(key, bounds.x / 2, bounds.y / 2);
    }

    @Override
    public int getY() {
        return (bounds.y / 2) + textHeight;
    }

    @Override
    public boolean isActive() {
        return this.active;
    }

    private void endActive() {
        this.active = false;
    }

    @Override
    public String getKey() {
        return key;
    }

    private void setKey() {
        int randomIdx = (int) (Math.random() * Box.getLetters().size());
        int i = 0;
        for (Character letter : Box.getLetters()) {
            if (i++ == randomIdx) {
                this.key = "" + letter;
            }
        }
    }

    private void setKey(String key) {
        this.key = key;
    }

    @Override
    public void setFound() {
        found = true;
    }

    private void setRandomDelta() {
        randomDelta = (int) (Math.random() * 15) + 9;
    }
}
