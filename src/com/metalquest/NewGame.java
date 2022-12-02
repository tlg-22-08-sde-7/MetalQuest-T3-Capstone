//package com.metalquest;
//
//import static java.lang.System.console;
//
//public class NewGame {
//    public static void newGame() {
//        // ask for user input to start new game or quit
//        System.out.println("Welcome to Metal Quest!");
//        System.out.println("Would you like to start a new game or quit?");
//        System.out.println("1. New Game");
//        System.out.println("2. Quit");
//        // while loop to check for valid input
//        while (true) {
//            // get user input
//            String input = console().readLine();
//            // check for valid input
//            if (input.equals("1")) {
//                // start new game
//                System.out.println("Starting new game...");
//                break;
//            } else if (input.equals("2")) {
//                // quit game using endgame method from Game.java
//                Game.endGame();
//            } else {
//                // invalid input
//                System.out.println("Invalid input. Please enter 1 or 2.");
//            }
//        }
//    }
//}
//
