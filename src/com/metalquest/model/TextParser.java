package com.metalquest.model;

import com.metalquest.view.View;

import java.security.spec.PKCS8EncodedKeySpec;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.metalquest.view.View.*;

/*
 * This class should handle all things related to parsing user input.
 */

public class TextParser {
    public static void main(String[] args) {
        String[] userInputArray = { "get", "money" };
        System.out.println(TextParser.keyWordIdentifier(userInputArray));
    }

    public static String[] userInputParser(String input) {

        if (input.equals("quit") || input.equals("q")) {
            quitOption();
        }
        if (input.equals("help") || input.equals("h")){
            View.getHelp(Player.getPlayer());
            input = getUserInput();
            userInputParser(input);
        }
        Pattern wordPattern = Pattern.compile("\\b(I|this|its|and|the|of|a|or|now)\\b\\s?");
        Matcher matchPattern = wordPattern.matcher(input);
        String inputString = matchPattern.replaceAll(" ").
                replaceAll("[\\p{Punct}]", "")
                .trim().replaceAll("[ ]+", " ");

        String[] inputArray = inputString.split(" ");

        if (inputArray.length != 2) {
            System.out.println("You entered an invalid option. Please enter two words [VERB], " +
                    "[NOUN] that describe what action you want to take.");
        }
        else {
            String verb = inputArray[0];
            String noun = inputArray[1];
        }

        return inputArray;
    }

    public static List<String> keyWordIdentifier(String[] userInputArray) {
        List<String> action = new ArrayList<>();
        Map<String, List<String>> wordMap = ExternalConverter.getVerbList();
        String verb = userInputArray[0];
        String noun = userInputArray[1];
        if (wordMap.containsKey(verb.toLowerCase(Locale.ROOT))) {
            action.add(verb);
        }
        for (Map.Entry<String, List<String>> entry: wordMap.entrySet()) {
            for (Object synonyms : entry.getValue()) {
                if (synonyms.equals(verb.toLowerCase(Locale.ROOT))) {
                    action.add(entry.getKey());
                }
            }
        }
        action.add(noun);

        return action;
    }
}