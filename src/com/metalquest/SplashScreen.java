package com.metalquest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class SplashScreen {
    public static void splashScreen() {
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