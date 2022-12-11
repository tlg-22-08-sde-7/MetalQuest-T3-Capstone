package com.metalquest.controller;

import com.metalquest.model.Location;
import com.metalquest.model.Player;

import static com.metalquest.view.View.*;
import java.util.*;

public class Game {
    public void execute() {
        Player player = Player.getPlayer();
        splashScreen();
        objectiveMsg();
        newGameQuestion();
        getUserInput();
        quitOption();
        System.out.println(player);
//        while (true) {
//            showCommands(player.getLocation());
//            System.out.println(player);
//            String input = getUserInput();
//            String[] parsedInput = userInputParser(input);
//            List<String> keywordsAction = keyWordIdentifier(parsedInput);
//            Location.commandsRoute(keywordsAction, player);
//        }
    }
}



