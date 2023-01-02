package com.gui;

import javax.imageio.ImageIO;
import javax.print.DocFlavor;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class ImageLoader {
    public BufferedImage image;

    public BufferedImage loadImage(String filePath)throws IOException {
        image = ImageIO.read(new File(filePath));
        return image;
    }

}