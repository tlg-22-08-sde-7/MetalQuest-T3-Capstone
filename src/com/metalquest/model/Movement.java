package com.metalquest.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Movement {
    private static JsonObject directions;
    private static JsonArray items;

    public void getJsonLocationData(String currentLocation) {
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
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void moveLocation(String direction, String currentLocation) {
        getJsonLocationData(currentLocation);
        for (Map.Entry<String, JsonElement> move : directions.entrySet()) {
            if (direction.equals(move.getKey())) {
                currentLocation = move.getValue().getAsString();
            }
        }
    }

    public void addToPlayerInventory(){}


}