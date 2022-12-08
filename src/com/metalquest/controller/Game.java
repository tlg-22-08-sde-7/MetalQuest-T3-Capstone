package com.metalquest.controller;

import com.google.gson.*;
import com.metalquest.model.Player;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
    public static Scanner scan = new Scanner(System.in);

    public String getUserInput() {
        System.out.println("Enter a command or \"quit\" to quit game: ");
        return scan.nextLine();
    }

    private void userInputParser(String input) {
        if (input.equals("quit") || input.equals("q")) {
            quitOption();
        }
        Pattern wordPattern = Pattern.compile("\\b(I|this|its|and|the|of|a|or|now)\\b\\s?");
        Matcher matchPattern = wordPattern.matcher(input);
        String inputString = matchPattern.replaceAll(" ").
                replaceAll("[\\p{Punct}]", "")
                .trim().replaceAll("[ ]+", " ");

        String[] inputArray = inputString.split(" ");
        System.out.println(inputArray.length);

        if(inputArray.length != 2){
            System.out.println("You entered an invalid option. Please enter two words [VERB], " +
                    "[NOUN] that describe what action you want to take.");
            String newInput = getUserInput();
            userInputParser(newInput);
        }
        else {
            String verb = inputArray[0];
            String noun = inputArray[1];
            keyWordIdentifier(verb, noun);
        }

    }


    private List<String> keyWordIdentifier(String verb, String noun) {
        List<String> action = new ArrayList<>();
        Gson gson = new Gson();
        Map<String, ArrayList> wordsMap = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader("json/verbs.json"));
            wordsMap = new HashMap<>();
            wordsMap = (Map<String, ArrayList>) gson.fromJson(br, wordsMap.getClass());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (wordsMap.containsKey(verb.toLowerCase(Locale.ROOT))) {
            action.add(verb);
        }
        for (Map.Entry<String, ArrayList> entry : wordsMap.entrySet()) {
            for (Object synonyms : entry.getValue()) {
                if (synonyms.equals(verb.toLowerCase(Locale.ROOT))) {
                    action.add(entry.getKey());
                }
            }
        }

        action.add(noun);

        System.out.println(action);
        return action;
    }


    private void endGame() {
        System.out.println("You have exited Metal Quest. Thanks for playing");
        System.exit(0);
    }

    private void newGameQuestion() {
        System.out.println();
        System.out.println("Would you like start a new game? (y/n)");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
            System.out.println("Starting new game");
        } else if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
            endGame();
        } else {
            System.out.println("Enter y or n");
        }
    }

    public void quitOption() {
        System.out.println("Are you sure? (yes or no)");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
            endGame();
        }
    }

    private void objectiveMsg() {
        try {
            String message = Files.readString(Path.of("resources/objective.txt"));
            System.out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void splashScreen() {
        System.out.println();
        System.out.println("Welcome to Metal Quest");
        try (BufferedReader br = new BufferedReader(new FileReader("images/banner.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCommands(String location) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get("json/locations.json"));
            JsonObject parser = JsonParser.parseReader(reader).getAsJsonObject();
            System.out.println("================================");
            System.out.println("Current Location: " + location);
            System.out.println("--------------------------------");

            for (JsonElement obj : parser.get("locations").getAsJsonArray()) {
                JsonObject place = obj.getAsJsonObject();
                if (location.equals(place.get("location").getAsString())) {
                    JsonObject directions = place.get("direction").getAsJsonObject();
                    JsonArray items = place.get("items").getAsJsonArray();
                    for (Map.Entry<String, JsonElement> move : directions.entrySet()) {
                        System.out.println("> Go " + move.getKey());
                    }
                    for (JsonElement item : items) {
                        System.out.println("> Use " + item);
                    }
                }
            }
            System.out.println("================================");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void execute() {
        splashScreen();
        objectiveMsg();
        newGameQuestion();
        while (true) {
            showCommands("Living Room");
            String input = getUserInput();
            userInputParser(input);
            break;
            //When the command “quit” is entered, the player must confirm if they wish to quit.
            // If They confirm, the game quits. If they do not confirm, the game does not quit
            // and returns to the command line where they can continue playing.
//            Write a method so that When the user enters quit, the player must confirm if they
//            wish to quit.
            // and


        }

    }

    private void printItems() {
        // print items from json file
        System.out.println("Items in the room: ");
        try {
            Reader reader = Files.newBufferedReader(Paths.get("json/locations.json"));
            JsonObject parser = JsonParser.parseReader(reader).getAsJsonObject();

            for (JsonElement obj : parser.get("locations").getAsJsonArray()) {
                JsonObject place = obj.getAsJsonObject();
                if ("Living Room".equals(place.get("location").getAsString())) {
                    JsonArray items = place.get("items").getAsJsonArray();
                    for (JsonElement item : items) {
                        System.out.println(item);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}


//            execute commands
//        }
////        newGameQuestion();
//    }
//
//}

//Process Command: takes the verb and noun and then processes within the game



