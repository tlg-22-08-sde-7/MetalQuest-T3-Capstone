package com.metalquest.controller;

import com.google.gson.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Game {
    public static Scanner scan;

    public String getUserInput(){
        Scanner userInputScanner = new Scanner(System.in);
        System.out.println("Enter a command: ");
        String input = userInputScanner.nextLine();
        return input;
    }

    private void userInputParser(String input) {
        String input2 = input.replaceAll("[^a-zA-Z\\\\']+", "")
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
        keyWordIdentifier(verb, noun);
    }


    private ArrayList<String> keyWordIdentifier(String verb, String noun) {
        ArrayList<String> action = new ArrayList<>();
        Gson gson = new Gson();
        JsonObject parser = null;
        Map<String, ArrayList> wordsMap = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/Ebb/Desktop/Team1/json/verbs.json"));
            wordsMap = new HashMap<>();
            wordsMap = (Map<String, ArrayList>) gson.fromJson(br, wordsMap.getClass());

            Reader reader = Files.newBufferedReader(Paths.get("/Users/Ebb/Desktop/Team1/json/commands.json"));
            parser = JsonParser.parseReader(reader).getAsJsonObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (wordsMap.containsKey(verb)){
            action.add(verb);
        }
            for (Map.Entry<String, ArrayList> entry : wordsMap.entrySet()) {
             for (Object synonyms : entry.getValue()){
                 if(synonyms.equals(verb.toLowerCase(Locale.ROOT))){
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
        newGameQuestion();
        while (true) {
            showCommands("Living Room");
            String input = getUserInput();
            userInputParser(input);
//            listen for commands
//            execute commands
            break;
        }

    }

}

//Process Command: takes the verb and noun and then processes within the game



