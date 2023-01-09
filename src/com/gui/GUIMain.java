package com.gui;

import com.metalquest.controller.Game;

public class GUIMain {
    public static void main(String[] args) {
       Frame.getInstance();
       Game game = new Game();
       game.execute();
       //new MenuBar();
    }
}
