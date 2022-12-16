package com.metalquest.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Location {

    public List<Room> getRooms() {
        return rooms;
    }

    private List<Room> rooms;

    public class Room {
        private String room;
        private Map<Direction, String> directions;
        private String description;
        private ArrayList items;

        public Room() {
        }

        public String getRoom() {
            return room;
        }

        public Map<Direction, String> getDirections() {
            return directions;
        }


        public String getDescription() {
            return description;
        }

        public ArrayList getItems() {
            return items;
        }

        @Override
        public String toString() {
            return " location name= " + getRoom() + "\n" + "description= " + getDescription() +
                    "\n" + " directions= " + getDirections() +
                    " items= " + getItems() + " ";
        }
    }

    public static void commandsRoute(List<String> keywords, Player player) {
        switch (keywords.get(0)) {
            case "get":
                player.getItem(player, keywords.get(1));
                break;
            case "drop":
                player.dropItem(player, keywords.get(1));
                break;
            case "go":
                player.moveLocation(keywords.get(1), player);
                break;
            case "play":
                player.playItem(keywords.get(1));
                break;
            case "drink":
                player.drink(player, keywords.get(1));
                break;
            case "dig":
                // dig func
                break;
            case "talk":
                player.talkToNPC(keywords.get(1));
                break;
            case "use":
                player.useItem(keywords.get(1));
                break;
            case "look":
                // System.out.println(player.lookItem(keywords.get(1)));
                break;
            default:
                System.out.println("Location.commandsRoute could not find a matching keyword" +
                        " for your entry of: " + keywords.get(0));
        }
    }
}