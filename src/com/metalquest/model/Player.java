package com.metalquest.model;
import java.util.ArrayList;
import java.util.List;

public class Player {

        double money = -20_000.00;
        String location = "Living Room";
        double fame = 0.0;
        int health = 50;
        List<Item> inventory = new ArrayList<>();

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

        public List<Item> getInventory() {
            return inventory;
        }

        public void setInventory(List<Item> inventory) {
            this.inventory = inventory;
        }

    }
