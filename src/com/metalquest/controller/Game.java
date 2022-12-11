package com.metalquest.controller;

import com.metalquest.model.Location;
import com.metalquest.model.Player;

import java.util.*;

public class Game {
    public void execute() {
        Player player = Player.getPlayer(-20_000, 0.0, 50);
        splashScreen();
        objectiveMsg();
        newGameQuestion();
        while (true) {
            showCommands(player.getLocation());
            System.out.println(player);
            String input = getUserInput();
            String[] parsedInput = userInputParser(input);
            List<String> keywordsAction = keyWordIdentifier(parsedInput);
            Location.commandsRoute(keywordsAction, player);
        }
    }
}



