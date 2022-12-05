package com.metalquest.view;

import static com.metalquest.controller.NewGameQuestion.newGameQuestion;
import static com.metalquest.controller.SplashScreen.splashScreen;
import static com.metalquest.controller.Objective.objectiveMsg;

public class MetalQuest {
    public static void main(String[] args) {
        splashScreen();

        objectiveMsg();

        newGameQuestion();
    }
}