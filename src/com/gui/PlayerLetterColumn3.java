package com.gui;

import com.metalquest.model.Player;

import java.awt.*;

public class PlayerLetterColumn3 extends Box {
    private Color color;
    private final Rectangle bounds;
    private final int textHeight = 25;
    private boolean found = false;
    public boolean active = true;
    private int remainingRounds = 5;
    private String key;
    private int randomDelta;

    public PlayerLetterColumn3(Color color, Dimension size) {
        this.color = color;
        bounds = new Rectangle(new Point(200, 0), size); // this is being used for calculating where the letter is

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
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font(g2d.getFont().getFontName(), Font.BOLD, textHeight));
        g2d.drawString(key, bounds.x / 2, bounds.y / 2);
    }

    @Override
    public int getY() {
        return (bounds.y / 2) + textHeight;
    }

    public boolean isActive() {
        return active;
    }

    private void endActive() {
        this.active = false;
    }

    public String getKey() {
        return this.key;
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
        this.key = "";
    }

    @Override
    public void setFound() {
        found = true;
    }

    private void setRandomDelta() {
        randomDelta = (int) (Math.random() * 15) + 9;
    }
}
