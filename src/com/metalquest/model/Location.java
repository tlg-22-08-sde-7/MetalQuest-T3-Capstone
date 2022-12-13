package com.metalquest.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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

//





    public static void commandsRoute(List<String> keywords, Player player) {
        switch (keywords.get(0)) {
            case "get":
                Player.getItem(player, keywords.get(1));
                break;
            case "drop":
                Player.dropItem(player, keywords.get(1));
                break;
            case "go":
                player.moveLocation(keywords.get(1), player);
                break;
            case "play":
                //play function
                break;
            case "drink":
                //drink fnc
                break;
            case "dig":
                // dig func
                break;
            case "talk":
               // System.out.println(player.talkToNPC(keywords.get(1)));
                break;
            case "use":
                //use func
                break;
            case "look":
                //System.out.println(player.lookItem(keywords.get(1)));
                break;
            default:
                System.out.println("error message goes here");

        }
    }
}