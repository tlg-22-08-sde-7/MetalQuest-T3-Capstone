package com.metalquest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class SplashScreen {
    public static void splashScreen() {
        System.out.println("Welcome to Metal Quest");
        try (BufferedReader br = new BufferedReader(new FileReader("images/banner.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}