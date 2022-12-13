package com.metalquest.model;

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
    public static void moveLocation(String direction, Player player) {
        Map<Direction, String> dirs = player.getLocation().getDirections();
//        System.out.println(dirs);
        for (Map.Entry<Direction, String> dir : dirs.entrySet()) {
            if (dir.getKey().toString().toUpperCase(Locale.ROOT).contains(direction)) {
                player.setLocation(dir.getValue());
                System.out.println(dir.getValue());
            }
//            if (direction.equals(dir.getKey().toString().toUpperCase())) {
//                player.setLocation(dir.getValue());
//            }
        }
    }

    // player can add and drop items
    public static void editPlayerInventory(Player player, List<String> keywords, String currentLocation) {
        String currentLoc = player.getLocation().getRoom();
        ArrayList itemsInRoom = player.getLocation().getItems();
        String command = keywords.get(0);
        String item = keywords.get(1);
        List<String> inventory = player.getInventory();
        player.getInventory().add("cellphone");

        if (command.equals("get")) {
            for (int i = 0; i < itemsInRoom.size(); i++) {
                if (itemsInRoom.toString().contains(item) && !inventory.contains(item)) {
                    player.getInventory().add(item);
                    itemsInRoom.remove(i);
                    System.out.println("Items in room: " + itemsInRoom.toString());
                    System.out.println("Added: " + item + " to your inventory");
                } else {
                    System.out.println(item + " is already in your inventory");
                    break;
                }
            }
        } else if (!itemsInRoom.toString().contains(item)) {
            System.out.println(item + " is not in this room. Please select a valid item.");
        }
        if (command.equals("drop") && inventory.contains(item)) {
            player.getInventory().remove(item);
            System.out.println("Removed: " + item + " from your inventory");
        } else if (!inventory.contains(item)) {
            System.out.println(item + " is not in your inventory.. select a valid item.");
            System.out.println("Items in inventory: " + inventory);
        }
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
                "Location: " + getLocation() + "\n" +
                "Fame: " + getFame() + "\n" +
                "Health: " + getHealth() + "\n" +
                "Inventory: " + getInventory() + "\n" +
                "========================";
    }
}
