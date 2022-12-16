package com.metalquest.controller;

import com.metalquest.model.Location;
import com.metalquest.model.Player;
import com.metalquest.model.TextParser;

import static com.metalquest.view.View.*;
import java.util.*;

public class Game {
    private final Player player = Player.getPlayer();

    public void execute() {
        splashScreen();
        objectiveMsg();
        boolean answer = newGameQuestion();

        while (answer){
            play(player);
        }
    }

    public void play(Player player) {
        System.out.println(player);
        String input = getUserInput();
        String[] arr = TextParser.userInputParser(input);
        if (arr.length == 2) {
            List<String> keys = TextParser.keyWordIdentifier(arr);
            Location.commandsRoute(keys, player);
        }
    }
}



