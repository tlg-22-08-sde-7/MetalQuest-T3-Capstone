package com.metalquest.model;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExternalConverter {
    public static void main(String[] args) {
        Item item = getItemObject("guitar pick");
        System.out.println(item.getName());
        System.out.println(item.getDescription());

        System.out.println();
        Item item1 = getItemObject("van halen t-shirt");
        System.out.println(item1.getDescription());
    }

    public static NPC getNPCObject(String characterToCreate) {
        NPC npcCreated = null;

        try {
            // Create a reader
            Reader reader = Files.newBufferedReader(Paths.get("resource/json/nonPlayableCharacter.json"));

            // Convert JSON array to list of npcs
            List<NPC> npcs = new Gson().fromJson(reader, new TypeToken<List<Item>>() {}.getType());

            // Retrieve the NPC
            for (NPC npc : npcs) {
                if (npc.getName().equals(characterToCreate)) {
                    npcCreated = npc;
                }
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }
        return npcCreated;
    }

    public static Item getItemObject(String itemToCreate) {
        // Create an item to return
        Item itemCreated = null;

        try {
            // Create a reader
            Reader reader = Files.newBufferedReader(Paths.get("resources/json/items.json"));

            // Convert JSON array to list of items
            List<Item> items = new Gson().fromJson(reader, new TypeToken<List<Item>>() {}.getType());

            // Retrieve the item
            for (Item item : items) {
                if (item.getName().equals(itemToCreate)) {
                    itemCreated = item;
                }
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        // Return the item
        return itemCreated;
    }

    private void showCommands(String location) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get("resources/json/locations.json"));
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

    private void printItems() {
        // print items from json file
        System.out.println("Items in the room: ");
        try {
            Reader reader = Files.newBufferedReader(Paths.get("resources/json/locations.json"));
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

    private List<String> keyWordIdentifier(String[] userInputArray) {
        List<String> action = new ArrayList<>();
        Gson gson = new Gson();
        HashMap<String, ArrayList<?>> wordsMap = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader("resources/json/verbs.json"));
            wordsMap = new HashMap<>();
            wordsMap = gson.fromJson(br, wordsMap.getClass());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String verb = userInputArray[0];
        String noun = userInputArray[1];
        if (wordsMap.containsKey(verb.toLowerCase(Locale.ROOT))) {
            action.add(verb);
        }
        for (Map.Entry<String, ArrayList<?>> entry : wordsMap.entrySet()) {
            for (Object synonyms : entry.getValue()) {
                if (synonyms.equals(verb.toLowerCase(Locale.ROOT))) {
                    action.add(entry.getKey());
                }
            }
        }
        action.add(noun);
        return action;
    }

    private String[] userInputParser(String input) {
        if (input.equals("quit") || input.equals("q")) {
            quitOption();
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
            String newInput = getUserInput();
            userInputParser(newInput);
        } else {
            String verb = inputArray[0];
            String noun = inputArray[1];

        }
        return inputArray;
    }
}