package com.metalquest.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
        if (inputArray.length > 2){
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
        Map<String,Object> wordsMap = new HashMap<String,Object>();
        wordsMap = (Map<String,Object>) gson.fromJson(br, wordsMap.getClass());
        System.out.println(wordsMap);

        wordsMap.forEach((k, v) -> System.out.println((k )));
        if (wordsMap.containsKey(verb)){
            action.add(verb);
        } else if (wordsMap.containsValue(verb)){
            for (Map.Entry<String, Object> entry : wordsMap.entrySet()) {
                if (entry.getValue().equals(verb)) {
                     action.add(entry.getKey());
                }
            }

        } else{
            System.out.println("Valid command. Please try again.");
        }

        return action;
    }


        public static void endGame () {

            System.out.println("You have exited Metal Quest. Thanks for playing");
            System.exit(0);
        }


    }

    //Process Command: takes the verb and noun and then processes within the game



