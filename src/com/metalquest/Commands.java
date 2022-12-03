package com.metalquest;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Commands {
    public static void main(String[] args) {
//        showCommands();
    }
    public static void showCommands(String location) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get("json/locations.json"));
            JsonObject parser = JsonParser.parseReader(reader).getAsJsonObject();

            for (JsonElement place : parser.get("locations").getAsJsonArray()) {
                JsonObject obj = place.getAsJsonObject();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}