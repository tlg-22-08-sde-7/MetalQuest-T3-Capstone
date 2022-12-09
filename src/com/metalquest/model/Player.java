package com.metalquest.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private static volatile Player player;
    private double money = -20_000.00;
    private String location = "Living Room";
    private double fame = 0.0;
    private int health = 50;
    private List<String> inventory = new ArrayList<>();

    private Player(double money, double fame, int health) {
        this.money = money;
        this.fame = fame;
        this.health = health;
    }

    public static Player getPlayer(double money, double fame, int health){
        if(player == null) {
            synchronized (Player.class) {
                if (player == null) {
                    player = new Player(money, fame, health);
                }

            }
        }
        return player;

    }

    public String lookItem(String item) {
        String itemDescription = "";
        try {
            Reader reader = Files.newBufferedReader(Paths.get("resources/json/items.json"));
            JsonObject parser = JsonParser.parseReader(reader).getAsJsonObject();

            for (JsonElement obj : parser.get("items").getAsJsonArray()) {
                JsonObject itemName = obj.getAsJsonObject();
                if (item.equals(itemName.get("name").getAsString())) {
                    itemDescription = itemName.get("description").getAsString();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemDescription;
    }

    public String talkToNPC(String npc) {
        return "Hello " + npc;
    }



    public double getFame() {
        return fame;
    }

    public void setFame(double fame) {
        this.fame = fame;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getInventory() {
        return inventory;
    }

    public void setInventory(List<String> inventory) {
        this.inventory = inventory;
    }


    public String toString() {
        return "========================\n" +
                "Player Status \n" +
                "-----------------------\n" +
                "Money: " + getMoney() + "\n" +
                "Location: " + getLocation() + "\n" +
                "Fame: " + getFame() + "\n" +
                "Health: " + getHealth() + "\n" +
                "Inventory: " + getInventory() + "\n" +
                "========================";
    }
}
