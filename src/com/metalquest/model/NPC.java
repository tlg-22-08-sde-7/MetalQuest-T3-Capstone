package com.metalquest.model;

class NPC {
    private String name;
    private String location;
    private String dialogue;

    public NPC(String name, String location, String dialogue) {
        this.name = name;
        this.location = location;
        this.dialogue = dialogue;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getDialogue() {
        return dialogue;
    }
}