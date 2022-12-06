package com.metalquest.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {


    public static Scanner scan;


    public void userInputParser(String input) throws FileNotFoundException {
        Scanner userInputScanner = new Scanner(System.in);
        String input1 = userInputScanner.nextLine();

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
            System.out.println("You entered an invalid option. Please enter two words [VERB], [NOUN] that describe what actio you want to take.");
        }
        String verb = inputArray[0];
        String noun = inputArray[1];
        keyWordIdentifier(verb, noun);
    }


    public ArrayList<String> keyWordIdentifier(String verb, String noun) throws FileNotFoundException {
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


    public static void endGame() {

        System.out.println("You have exited Metal Quest. Thanks for playing");
        System.exit(0);
    }

    public static void newGameQuestion() {
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

    public static void objectiveMsg() {
        try {
            String message = Files.readString(Path.of("resources/objective.txt"));
            System.out.println(message);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void splashScreen() {
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

    public void execute() {
        splashScreen();
        objectiveMsg();
        newGameQuestion();

        /*
            while (true) {
                display environment info
                listen for commands
                execute commands
            }
         */
    }

}

//Process Command: takes the verb and noun and then processes within the game



