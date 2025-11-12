/**
 * Write a description of class colorlab here.
 *
 * @author Danial Ganijee
 * @version 11/11/2025
 */
import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
public class colorlab
{
    public static void main (String[] args)
    {
        // Change blue by a factor of 50%
        Picture mark = new Picture("images/blue-mark.jpg");
        Pixel[] pixels;
        pixels = mark.getPixels();
        for (Pixel dot: pixels)
            {
                int blueNum = (int)((double)dot.getBlue() * 0.5);
                dot.setBlue(blueNum);
            }
        mark.explore();
        
        
        // negate
        Picture moon = new Picture("images/moon-surface.jpg");
        Pixel[] pixels1;
        pixels1 = moon.getPixels();
        for (Pixel dot: pixels1)
            {
                int numRED = Math.abs(dot.getRed() - 255);
                int numGREEN = Math.abs(dot.getGreen() - 255);
                int numBLUE = Math.abs(dot.getBlue() - 255);
                
                dot.setRed(numRED);
                dot.setGreen(numGREEN);
                dot.setBlue(numBLUE);
            }
        moon.explore();
        
        // greyscale
        Picture snowman = new Picture("images/snowman.jpg");
        Pixel[] pixels2;
        pixels2 = snowman.getPixels();
        
        for (Pixel dot: pixels2)
        {
            int avg = (int)((double)(dot.getRed() + dot.getBlue() + dot.getGreen())/3.0);
            dot.setRed(avg); dot.setGreen(avg); dot.setBlue(avg); 
            
        }
        snowman.explore();
        
        // lighten
        Picture beach = new Picture("images/beach.jpg");
        Pixel[] pixels3;
        pixels3 = beach.getPixels();
        
        for (Pixel dot: pixels3)
        {
            int Rnum = dot.getRed() + 50; dot.setRed(Rnum);
            int Gnum = dot.getGreen() + 50; dot.setGreen(Gnum);
            int Bnum = dot.getBlue() + 50; dot.setBlue(Bnum);
        }
        beach.explore();
        
        // range of pixels
        Picture ferris = new Picture("images/ferris.jpg");
        Pixel[] pixels4;
        pixels4 = ferris.getPixels();
        Color sky = new Color(135, 206, 235);
        for (Pixel dot: pixels4)
        {
            int R = dot.getRed();
            if (R < 40)
            {
                dot.setColor(sky);
            }
        }
        ferris.explore();
        
        // blueify your face
        Picture barbara = new Picture("images/barbaraS.jpg");
        Pixel[] pixels5;
        pixels5 = barbara.getPixels();
        for (Pixel dot: pixels5)
        {
            int Red = dot.getRed();
            if (Red < 220 && Red > 190)
            {
                int Blue = dot.getBlue() + 150;
                dot.setBlue(Blue);
            }
        }
        barbara.explore();
        
        
        
        
    }
}
