package com.metalquest.model;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ExternalConverter {
    public static void main(String[] args) {
        Item item = getItemObject("leather jacket");
        System.out.println(item.getName());
        System.out.println(item.getDescription());
    }

    public static NPC getNPCObject() {
        try {
            Reader reader = Files.newBufferedReader(Paths.get("json/npc.json"));
            JsonObject NPCJsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            String NPCJsonString = NPCJsonObject.getAsString();
            System.out.println(NPCJsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Item getItemObject(String itemToCreate) {
        // Create an item to return
        Item itemCreated = null;

        try {
            // Create a Gson instance
            Gson gson = new Gson();

            // Create a reader
            Reader reader = Files.newBufferedReader(Paths.get("resources/json/items.json"));

            // Convert JSON array to list of items
            List<Item> items = new ArrayList<>();
            items = new Gson().fromJson(reader, new TypeToken<List<Item>>() {}.getType());

            // Look for item
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
}