package com.metalquest.model;

import java.util.ArrayList;

public class Scene {
    private Integer scene;
    private String location;
    private String text;
    private ArrayList requirements;
    private boolean played;

    public Integer getScene() {
        return scene;
    }

    public String getLocation() {
        return location;
    }

    public String getText() {
        return text;
    }

    public ArrayList getRequirements() {
        return requirements;
    }

    public boolean isPlayed() {
        return played;
    }

}