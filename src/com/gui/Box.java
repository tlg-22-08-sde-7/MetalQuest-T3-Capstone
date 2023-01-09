package com.gui;

import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Box {
    private static final Set<Character> letters =
            new HashSet<>(Arrays.asList(
                    'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
                    'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                    'w', 'x', 'y', 'z'
            ));

    public abstract void update(Dimension size);
    public abstract void paint(Graphics2D g2d);
    public abstract int getY();
    public abstract String getKey();
    public abstract boolean isActive();
    public abstract void setFound();

    public static Set<Character> getLetters() {
        return letters;
    }
}
