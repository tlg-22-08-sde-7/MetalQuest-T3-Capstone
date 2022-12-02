package com.metalquest;

import java.util.Scanner;

public class Game {


    public static Scanner scan;


    public void getUserInput(String input) {
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
        String verb = inputArray[0];
        String noun = inputArray[1];
        keyWordIdentifier(verb, noun);
    }
    //KEYWORDS: "GO", "GET", "PLAY", "DRINK",
    //
    //


    public String[] keyWordIdentifier(String verb, String noun) {

        String[] action = {"Go", "South",};

        return action;
    }


        public static void endGame () {

            System.out.println("You have exited Metal Quest. Thanks for playing");
            System.exit(0);
        }
        //need to add an if statement for when user
        // enters "quit" or "exit" endGame() is called

    }



