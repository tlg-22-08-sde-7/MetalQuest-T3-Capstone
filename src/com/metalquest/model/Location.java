package com.metalquest.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Location {

    public List<Room> getRooms() {
        return rooms;
    }

    private List<Room>rooms;

    public class Room{
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
            return "Location [ locationName=" + getRoom() +
                    " directions=" + getDirections() + " description=" + getDescription() +
                    " items=" + getItems() +" ]";
        }
    }







    //    protected static JsonObject directions;
//    protected static JsonArray items;
//
//    public static void getJsonLocationData(String currentLocation) {
//        try {
//            Reader reader = Files.newBufferedReader(Paths.get("resources/json/locations.json"));
//            JsonObject parser = JsonParser.parseReader(reader).getAsJsonObject();
//            for (JsonElement obj : parser.get("locations").getAsJsonArray()) {
//                JsonObject place = obj.getAsJsonObject();
//                if (currentLocation.equals(place.get("location").getAsString())) {
//                    directions = place.get("direction").getAsJsonObject();
//                    items = place.get("items").getAsJsonArray();
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void moveLocation(String direction, Player player) {
//        getJsonLocationData(player.getLocation());
//        for (Map.Entry<String, JsonElement> move : directions.entrySet()) {
//            if (direction.equals(move.getKey())) {
//                String currentLocation = move.getValue().getAsString();
//                player.setLocation(currentLocation);
//            } else {
//                System.out.println("Please select a valid move option.");
//                break;
//                //
//            }
//        }
//    }
//
//    public static void editPlayerInventory(Player player, List<String> keywords, String currentLocation) {
//        getJsonLocationData(player.getLocation());
//        String command = keywords.get(0);
//        String item = keywords.get(1);
//        player.getInventory().add("rolex");
//        if (command.equals("get")) {
//            for (int i = 0; i < items.size(); i++) {
//                if (items.toString().contains(item) && !player.getInventory().contains(item)) {
//                    player.getInventory().add(item);
//                    items.remove(i);
//                    System.out.println("Items in room: " + items.toString());
//                    System.out.println("Added: " + item + " to your inventory");
//                } else {
//                    System.out.println(item + " is already in your inventory");
//                    break;
//                }
//            }
//        } else if (!items.toString().contains(item)) {
//            System.out.println(item + " is not in this room. Please select a valid item.");
//        }
//        if (command.equals("drop") && items.toString().contains(item)) {
//            player.getInventory().remove(item);
//            System.out.println("Removed: " + item + " from your inventory");
//        } else if (!player.getInventory().contains(item)) {
//            System.out.println(item + " is not in this room, Please select a valid item.");
//            System.out.println("Items in room: " + items);
//        }
//    }
//
//    public static void commandsRoute(List<String> keywords, Player player) {
//        switch (keywords.get(0)) {
//            case "get":
//            case "drop":
//                editPlayerInventory(player, keywords, player.getLocation());
//                break;
//            case "go":
//                moveLocation(keywords.get(1), player);
//                break;
//            case "play":
//                //play function
//                break;
//            case "drink":
//                //drink fnc
//                break;
//            case "dig":
//                // dig func
//                break;
//            case "talk":
//                System.out.println(player.talkToNPC(keywords.get(1)));
//                break;
//            case "use":
//                //use func
//                break;
//            case "look":
//                System.out.println(player.lookItem(keywords.get(1)));
//                break;
//            default:
//                System.out.println("error message goes here");
//
//        }
//    }
}