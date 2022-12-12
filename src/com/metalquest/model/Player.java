package com.metalquest.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private static volatile Player player;
    //private Location location = ExternalConverter.getLocationObject("Living Room");
    private Location.Room room = ExternalConverter.getLocationObject("Living Room");
    //private String location;
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

    public String lookItem(Item item) {
        return item.getDescription();
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
