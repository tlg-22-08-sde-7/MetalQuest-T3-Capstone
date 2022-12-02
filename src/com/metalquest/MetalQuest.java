package com.metalquest;

import static com.metalquest.NewGameQuestion.newGameQuestion;
import static com.metalquest.SplashScreen.splashScreen;
import static com.metalquest.Objective.objectiveMsg;

class MetalQuest {
    public static void main(String[] args) {
        splashScreen();

        objectiveMsg();

        newGameQuestion();
    }
}