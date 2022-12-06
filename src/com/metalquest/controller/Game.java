package com.metalquest.controller;

import com.google.gson.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    public static Scanner scan;
    private String commandEntered;

    private void userInputParser(String input) {
        Scanner userInputScanner = new Scanner(System.in);
        String input1 = scan.nextLine();

        String input2 = input1.replaceAll("[^a-zA-Z\\\\']+", "")
                .replaceAll("of", "")
                .replaceAll("the", "")
                .replaceAll("and", "")
                .replaceAll("a", "");


        if (input.equals("exit")) {
            endGame();
        }
        String[] inputArray = input.split(" ");
        if (inputArray.length > 2) {
            System.out.println("You entered an invalid option. Please enter two words [VERB], " +
                    "[NOUN] that describe what actio you want to take.");
        }
        String verb = inputArray[0];
        String noun = inputArray[1];
        // keyWordIdentifier(verb, noun);
    }


    private ArrayList<String> keyWordIdentifier(String verb, String noun) throws FileNotFoundException {
        ArrayList<String> action = new ArrayList<>();

        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader("./words.json"));
        Map<String, Object> wordsMap = new HashMap<>();
        wordsMap = (Map<String, Object>) gson.fromJson(br, wordsMap.getClass());
        System.out.println(wordsMap);

        wordsMap.forEach((k, v) -> System.out.println((k)));
        if (wordsMap.containsKey(verb)) {
            action.add(verb);
        } else if (wordsMap.containsValue(verb)) {
            for (Map.Entry<String, Object> entry : wordsMap.entrySet()) {
                if (entry.getValue().equals(verb)) {
                    action.add(entry.getKey());
                }
            }

        } else {
            System.out.println("Valid command. Please try again.");
        }

        return action;
    }


    private void endGame() {
        System.out.println("You have exited Metal Quest. Thanks for playing");
        System.exit(0);
    }

    private void newGameQuestion() {
        System.out.println();
        System.out.println("Would you like start a new game? (y/n)");
        Scanner scan = new Scanner(System.in);
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
            System.out.println("Starting new game");
        } else if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
            endGame();
        } else {
            System.out.println("Enter y or n");
            newGameQuestion();
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void execute() {
        splashScreen();
        objectiveMsg();
        while (true) {
            showCommands("Living Room");
            System.out.println("Enter a Command");
            Scanner scan = new Scanner(System.in);
            String commandEntered = scan.nextLine();
            // print items in location
            printItems();
            lookAtCommand();

            executeCommand(commandEntered);
            }
        }

    private void executeCommand(String commandEntered) {
        String[] command = commandEntered.split(" ");
        if (command.length == 1) {
            if (command[0].equalsIgnoreCase("look")) {
                System.out.println("You are in the living room");
            } else if (command[0].equalsIgnoreCase("exit")) {
                endGame();
            } else {
                System.out.println("Invalid command");
            }
        } else if (command.length == 2) {
            if (command[0].equalsIgnoreCase("go")) {
                if (command[1].equalsIgnoreCase("north")) {
                    System.out.println("You are in the kitchen");
                } else if (command[1].equalsIgnoreCase("south")) {
                    System.out.println("You are in the bedroom");
                } else if (command[1].equalsIgnoreCase("east")) {
                    System.out.println("You are in the bathroom");
                } else if (command[1].equalsIgnoreCase("west")) {
                    System.out.println("You are in the garage");
                } else {
                    System.out.println("Invalid direction");
                }
            } else if (command[0].equalsIgnoreCase("use")) {
                if (command[1].equalsIgnoreCase("key")) {
                    System.out.println("You unlocked the door...");
                } else if (command[1].equalsIgnoreCase("Thor's hammer")) {
                    System.out.println("You broke the door.... ");
                } else {
                    System.out.println("Invalid item");
                }
            } else {
                System.out.println("Invalid command");
            }
        } else {
            System.out.println("Invalid command");
        }
    }
    

    private void lookAtCommand() {
        System.out.println("Enter 'look at' to learn more about this item");
        printItems();
        Scanner scan = new Scanner(System.in);
        String commandEntered = scan.nextLine();
        if (commandEntered.equalsIgnoreCase("look at")) {
            System.out.println("You are in the living room");
        } else {
            System.out.println("Invalid command");
            
        }
    }


    private void printItems( ) {
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



