package com.metalquest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Objective {

    public void objectiveMsg() {
        try {
            String message = Files.readString(Path.of("resources/objective.txt"));
            System.out.println(message);
       }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}