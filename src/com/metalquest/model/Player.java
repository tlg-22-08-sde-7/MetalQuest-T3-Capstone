package com.metalquest.model;

import com.google.gson.internal.bind.util.ISO8601Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Player {

    private static volatile Player player;
    private Location.Room room = ExternalConverter.getLocationObject("Living Room");
    private double money = -20_000.00;
    private double fame = 0.0;
    private int health = 50;
    private List<String> inventory = new ArrayList<>();

    private Player() {
    }

    public static Player getPlayer() {
        if (player == null) {
            synchronized (Player.class) {
                if (player == null) {
                    player = new Player();
                }
            }
        }
        return player;
    }

    // player can move locations
    public static void moveLocation(String move, Player player) {
        Map<Direction, String> directions = player.getLocation().getDirections();
        for (Map.Entry<Direction, String> direction : directions.entrySet()) {
            if (move.toUpperCase(Locale.ROOT).equals(direction.getKey().toString().toUpperCase(Locale.ROOT))) {
                player.setLocation(direction.getValue());
                System.out.println(direction.getValue());
            }
        }
    }

    // player can add items
    //player can add and drop items
    public static void getItem(Player player, String item) {
        ArrayList itemsInRoom = player.getLocation().getItems();
        List<String> inventory = player.getInventory();
            if (itemsInRoom.toString().contains(item) && !inventory.contains(item)) {
                inventory.add(item);
                itemsInRoom.remove(item);
                System.out.println("Items in room: " + itemsInRoom);
                System.out.println("Added: " + item + " to your inventory");
                System.out.println("Your inventory: " + inventory);
            }
            else if (inventory.contains(item)) {
                System.out.println(item + " is already in your inventory");
                System.out.println(inventory);
            } else {
                System.out.println(item + " is not in this room.");
            }
    }

//drop items
public void dropItem(Player player, String item){
    ArrayList itemsInRoom = player.getLocation().getItems();
    List<String> inventory = player.getInventory();
    if (inventory.contains(item)) {
        player.getInventory().remove(item);
        itemsInRoom.add(item);
        System.out.println("Removed: " + item + " from your inventory");
        System.out.println(player.getInventory());
    }
    else if (!inventory.contains(item)) {
        System.out.println(item + " is not in your inventory.. select a valid item.");
        System.out.println("Items in inventory: " + inventory);
    }
}

//drink
public void drink(Player player, String item){
    if(player.getInventory().contains(item.toLowerCase(Locale.ROOT))){
        if(item.equals("oj") || item.equals("water") || item.equals("sunnyd")){
            System.out.println("You drank " + item);
            System.out.println("Good choice, your health just increased.");
            player.setHealth(player.getHealth() + 15);
            player.getInventory().remove(item);
        }
        if (item.equals("adultbeverage") || item.equals("purplestuff")){
            System.out.println("You drank " + item);
            System.out.println("You feel worse then before. Your health has decreased");
            player.setHealth(player.getHealth() - 20);
            player.getInventory().remove(item);
        }

    } else if (player.getLocation().getItems().contains(item)){
        System.out.println("You must first add beverage to you inventory");
    } else {
        System.out.println("That is not valid. Try again");
    }
}

    public void useItem(String item){

        if (player.getInventory().contains(item)){
            System.out.println("you have used the " + item);
            player.setFame(getFame() + 9);
            player.getInventory().remove(item);
        } else {
            System.out.println(item + " is not in your inventory");
        }
    }

    public void playItem(String item){
        if(player.getInventory().contains(item)){
            if (item.toLowerCase(Locale.ROOT).equals("guitar")){
                System.out.println("you are playing the guitar");
            } else {
                System.out.println("This is not a musical item");
            }
        }
    }


    public void lookItem(Item item) {
        System.out.println(item.getDescription());
        //return item.getDescription().toString();
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

    public Location.Room getLocation() {
        return room;
    }

    public void setLocation(String room) {
        this.room = ExternalConverter.getLocationObject(room);
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
                "Location: " + getLocation().getRoom() + "\n " + getLocation().getDescription() + " \n" +
               "Directions: " + getLocation().getDirections() + " \n" + "Items in room: " + getLocation().getItems() +
                "\n" + "Fame: " + getFame() + "\n" +
                "Health: " + getHealth() + "\n" +
                "Inventory: " + getInventory() + "\n" +
                "========================";
    }
}
