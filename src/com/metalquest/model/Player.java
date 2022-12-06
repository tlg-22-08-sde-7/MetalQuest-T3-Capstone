package com.metalquest.model;
import java.util.ArrayList;

    public class Player {

        double money;
        String location;
        double fame;
        String health;
        ArrayList inventory = new ArrayList();

        public double getFame() {
            return fame;
        }

        public void setFame(double fame) {
            this.fame = fame;
        }

        public String getHealth() {
            return health;
        }

        public void setHealth(String health) {
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

        public ArrayList getInventory() {
            return inventory;
        }

        public void setInventory(ArrayList inventory) {
            this.inventory = inventory;
        }




    }
