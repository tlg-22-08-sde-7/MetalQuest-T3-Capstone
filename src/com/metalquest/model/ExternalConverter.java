package com.metalquest.model;

import com.google.gson.*;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExternalConverter {
    public static void main(String[] args) {
        getNPCObject();
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

    public static Item getItemObject(String item) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get("json/items.json"));
            JsonObject parser = JsonParser.parseReader(reader).getAsJsonObject();

            for (JsonElement element : parser.getAsJsonArray("items")) {
                if (item.equals(element)) {
                    System.out.println(element);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}