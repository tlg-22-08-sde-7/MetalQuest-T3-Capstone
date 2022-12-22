package com.metalquest.controller;

import com.metalquest.model.Location;

import javax.swing.*;
import java.awt.*;

public class GUIControllerPane extends JPanel {

    private GUIControllerPane GUIControllerPane;

    public GUIControllerPane getInstance() {
        if (GUIControllerPane != null) {
            GUIControllerPane = new GUIControllerPane();
        }

        return GUIControllerPane;
    }

    public boolean enter(Location.Room room) {
        boolean success = true;

        switch (room.getRoom().toLowerCase()) {
            case "living room":
                livingRoom();
                break;
            case "kitchen":
                kitchen();
                break;
            case "backyard":
                backyard();
                break;
            case "master bedroom":
                masterBedroom();
                break;
            case "bathroom":
                bathroom();
                break;
            case "garage":
                garage();
                break;
            default:
                success = false;
                System.out.println("ERROR - room.getRoom() is returning an unrecognized" +
                        "string. This is an application error.");
        }

        return success;
    }

    private void livingRoom() {

    }

    private void kitchen() {

    }

    private void backyard() {

    }

    private void masterBedroom() {

    }

    private void bathroom() {

    }

    private void garage() {

    }

}
