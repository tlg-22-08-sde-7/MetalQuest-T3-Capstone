package com.gui;

import com.metalquest.controller.Game;

public class GUIMain {
    public static void main(String[] args) {

        new Frame();
       Game game = new Game();
       game.execute();
    }
}
