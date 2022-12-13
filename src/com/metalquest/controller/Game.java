package com.metalquest.controller;

import com.metalquest.model.Location;
import com.metalquest.model.Player;
import com.metalquest.model.TextParser;

import static com.metalquest.view.View.*;
import java.util.*;

public class Game {
    private Player player = Player.getPlayer();
    private TextParser textParser = new TextParser();

    public void execute() {
        System.out.println(player);
        showCommands(player);
        splashScreen();
        objectiveMsg();
        newGameQuestion();
        //currentScenes(playe);
        int i = 0;
        while (i < 10){  ///just a temp dummy loop for testing
            play(player);
            currentScenes(player);
            i++;
        }

//        getUserInput();
//        quitOption();
//        System.out.println(player);
//        while (true) {
//            showCommands(player.getLocation());
//            System.out.println(player);
//            String input = getUserInput();
//            String[] parsedInput = userInputParser(input);
//            List<String> keywordsAction = keyWordIdentifier(parsedInput);
//            Location.commandsRoute(keywordsAction, player);
//        }
    }

    public static void play(Player player) {
        showCommands(player);
        String input = getUserInput();
        String[] arr = TextParser.userInputParser(input);
        if (arr.length == 2) {
            List<String> keys = TextParser.keyWordIdentifier(arr);
            Location.commandsRoute(keys, player);
        }
    }
}



