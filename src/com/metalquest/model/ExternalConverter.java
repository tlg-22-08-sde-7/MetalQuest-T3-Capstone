package com.metalquest.model;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ExternalConverter {
    private static Reader reader;

    public static void main(String[] args) {
        Item item = getItemObject("guitar pick");
        System.out.println(item.getName());
        System.out.println(item.getDescription());
        getScenes(0);
//
//        System.out.println();
//        Item item1 = getItemObject("van halen t-shirt");
//        System.out.println(item1.getDescription());
//
//        System.out.println();
//        NPC npc = getNPCObject("Stranger");
//        System.out.println(npc.getName());
//
//        System.out.println();
//
        //System.out.println(location.getLocationName());
        //System.out.println(location.getDirectionStringMap());
        //System.out.println(location.getDescription());
        //System.out.println(location.getItems());
        Location.Room room = getLocationObject("Living Room");
        System.out.println(room.getRoom());

        System.out.println(getVerbList());

    }

    public static NPC getNPCObject(String characterToCreate) {
        NPC npcCreated = null;

        try {
            // Create a reader
            reader = Files.newBufferedReader(Paths.get("resources/json/nonPlayableCharacter.json"));

            // Convert JSON array to list of npcs
            List<NPC> npcs = new Gson().fromJson(reader, new TypeToken<List<NPC>>() {}.getType());

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
            reader = Files.newBufferedReader(Paths.get("resources/json/items.json"));

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

    public static Location.Room getLocationObject(String name) {
        // Create an item to return
//        Location locationCreated = null;
        Location location = null;
        Location.Room room = null;

        try {
            // Create a reader
            reader = Files.newBufferedReader(Paths.get("resources/json/locations.json"));

            // Convert JSON array to list of items
            // List<Location> locations = new Gson().fromJson(reader, new TypeToken<List<Location>>() {}.getType());
            location = new Gson().fromJson(reader, Location.class);
            room = location.getRooms().get(1);


           // System.out.println(location.getRooms().size());
            // Retrieve the item
         for(int i = 0; i < location.getRooms().size(); i++){
             if(location.getRooms().get(i).getRoom().contains(name)){
                 room = location.getRooms().get(i);

             }

         }
            //System.out.println(location.getRooms().get(0).getRoom());
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        // Return the item
//        return locationCreated;
        return room;
    }

    public static Map getVerbList() {
        Gson gson = new Gson();
        Map wordsMap = new HashMap<>();

        try {
            reader = new BufferedReader(new FileReader("resources/json/verbs.json"));
            wordsMap = gson.fromJson(reader, wordsMap.getClass());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return wordsMap;
    }

    public static void getScenes(Integer index) {
        try {
            reader = new BufferedReader(new FileReader("resources/json/scenes.json"));
            List<Scene> scenes = new Gson().fromJson(reader, new TypeToken<List<Scene>>() {}.getType());
            System.out.println(scenes.get(index).getText());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}