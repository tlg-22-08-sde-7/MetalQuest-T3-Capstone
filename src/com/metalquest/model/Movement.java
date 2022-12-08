package com.metalquest.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Movement {
    protected static JsonObject directions;
    protected static JsonArray items;

    public static void getJsonLocationData(String currentLocation) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get("json/locations.json"));
            JsonObject parser = JsonParser.parseReader(reader).getAsJsonObject();
            for (JsonElement obj : parser.get("locations").getAsJsonArray()) {
                JsonObject place = obj.getAsJsonObject();
                if (currentLocation.equals(place.get("location").getAsString())) {
                    directions = place.get("direction").getAsJsonObject();
                    items = place.get("items").getAsJsonArray();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String moveLocation(String direction, String currentLocation) {
        getJsonLocationData(currentLocation);
        String newLocation = "";
        for (Map.Entry<String, JsonElement> move : directions.entrySet()) {
            if (direction.equals(move.getKey())) {
                newLocation = move.getValue().getAsString();
            }
        }
        return newLocation;
    }

    public static void editPlayerInventory(Player player, List<String> keywords, String currentLocation) {
        getJsonLocationData(currentLocation);
        String command = keywords.get(0);
        String item = keywords.get(1);
        //player.getInventory().add("rolex");
        if (command.equals("get")) {

            for (int i = 0; i < items.size(); i++) {
                if (items.toString().contains(item)) {
                    player.getInventory().add(item);
                    items.remove(i);
                    System.out.println("Items in room: " + items.toString());
                    System.out.println("Added: " + item + " to your inventory");
                }
            }
            } else if (!items.toString().contains(item)){
            System.out.println(item + " is not in this room. Please select a valid item.");
        }
        if(command.equals("drop") && items.toString().contains(item)){
            player.getInventory().remove(item);
            System.out.println("Removed: " + item + " from your inventory");
        } else if (!player.getInventory().contains(item)) {
            System.out.println(item + " is not in your inventory, Please select a valid item.");
        }

    }


    public static void commandsRoute(List<String> keywords, Player player, String currentLocation){
        switch (keywords.get(0)){
            case "get":
            case "drop":
                editPlayerInventory(player, keywords, currentLocation);
                break;
            case "go":
                //call move function
                break;
            case "play":
                //play function
                break;
            case "drink":
                //drink fnc
                break;
            case "dig":
                //func
                break;
            case "talk":
                //
                break;
            case "use":
                //
                break;
            default:
                System.out.println("error message");

        }


    }

}