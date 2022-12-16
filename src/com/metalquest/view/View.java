package com.metalquest.view;

import com.metalquest.model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class View {
    public static Scanner scan = new Scanner(System.in);

    public static void splashScreen() {
        System.out.println();
        System.out.println("Welcome to Metal Quest");
        try (BufferedReader br = new BufferedReader(new FileReader("resources/images/banner.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
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

    public static boolean newGameQuestion() {
        System.out.println();
        System.out.println("Would you like start a new game? (y/n)");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
            System.out.println("Starting new game");
            return true;
        } else if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
            endGame();
        } else {
            System.out.println("Enter y or n");
        }
        return false;
    }


    public static String getUserInput() {
        System.out.println("Enter a command to take action, or type \"help\" to show command  \"quit\" to quit game: ");
        return scan.nextLine();
    }

    public static void quitOption() {
        System.out.println("Are you sure? (yes or no)");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
            endGame();
        }
    }

    private static void endGame() {
        System.out.println("You have exited Metal Quest. Thanks for playing");
        System.exit(0);
    }

    public static void getHelp(Player player) {
        System.out.println("=====================");
        System.out.println("Available Commands");
        System.out.println("---------------------");
        for (Map.Entry<Direction, String> location : player.getLocation().getDirections().entrySet()) {
            System.out.println(">Go " + location.getKey());
        }
        for (Object item : player.getLocation().getItems()) {
            System.out.println(">Get " + item);
        }
        moreCommands(player);

        System.out.println("=====================");
    }

    public static void moreCommands(Player player){
        ArrayList<String > drinks = new ArrayList<>(
                Arrays.asList("oj", "water", "adultbeverage", "sunnyd", "purplestuff"));

      if (player.getInventory().size() >= 1) {
          for (int i = 0; i < drinks.size() - 1; i++) {
              if (player.getInventory().contains(drinks.get(i))) {
                  System.out.println(">Drink " + drinks.get(i));
              }
          }
      }
        for (Object item : player.getInventory()) {
            if (!drinks.contains(item)){
                System.out.println(">Use " + item);
            }
        }
    }

    public static void currentScenes(Player player, String move) {
        System.out.println(player.getLocation().getDescription());
        Map<Direction, String> directions = player.getLocation().getDirections();
        for (Map.Entry<Direction, String> direction : directions.entrySet()) {
            if (move.equals(direction.getKey().toString())) {
                currentScenes(player, move);
            }
        }
    }
}