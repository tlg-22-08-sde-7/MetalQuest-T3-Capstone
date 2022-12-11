package com.metalquest.model;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

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
}