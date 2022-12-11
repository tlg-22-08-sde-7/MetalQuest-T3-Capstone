package com.metalquest.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private static volatile Player player;
    private double money = -20_000.00;
    // private String location = "Living Room";
    private Location location;
    private double fame = 0.0;
    private int health = 50;
    private List<String> inventory = new ArrayList<>();

    private Player(double money, double fame, int health) {
        this.money = money;
        this.fame = fame;
        this.health = health;
    }

    public static Player getPlayer(double money, double fame, int health) {
        if (player == null) {
            synchronized (Player.class) {
                if (player == null) {
                    player = new Player(money, fame, health);
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
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
