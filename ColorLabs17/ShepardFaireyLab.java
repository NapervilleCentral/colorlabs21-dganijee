
/**
 * ShepardFaireyLab.
 * 
 * @author Danial Ganijee 
 * @version 11/12/2025
 */
import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

public class ShepardFaireyLab
{
    public static void main(String[] args)
    {
        /*method 1 change (balanced approach)*/
        Picture danial = new Picture("images/danial.jpg");
        Pixel[] pixels; pixels = danial.getPixels(); // create array of pixels for selfie 
        
        //make SF colors
        Color darkblue = new Color(0,0,139); // range 0-64
        Color red = new Color(230,0,0); // range 64-128
        Color lightblue = new Color(173,216,230); // range 128-192 
        Color offwhite = new Color(230,230,230); //range 192-255
        
        // find greyscale values and set colors
        for (Pixel dot : pixels)
        {
            int avg = (int)((dot.getRed() + dot.getGreen() + dot.getBlue()) / 3.0);
            if (avg < 64)
                dot.setColor(darkblue);
            else if (avg < 128)
                dot.setColor(red);
            else if (avg < 192)
                dot.setColor(lightblue);
            else
                dot.setColor(offwhite);
        }
        danial.explore();
        
        //---------------------------------------------------------------------
        /*method 2 change (find min and max)*/
        Picture danial2 = new Picture("images/danial.jpg");
        Pixel[] pixels2 = danial2.getPixels();
        int max = 0; int min = 0;
        for (Pixel dot : pixels2) // find max and min
        {
            int avg = (int)((dot.getRed() + dot.getGreen() + dot.getBlue()) / 3.0);
            if (avg > max)
                    max = avg;
            if (avg < min)
                    min = avg;
        }
        
        //buckets (find size based on max and min, then make four pixel ranges for each bucket)
        int bucketSize = (max-min)/4; //determine bucket size
        // pixel ranges:
        int bucket1 = min + bucketSize;
        int bucket2 = bucket1 + bucketSize;
        int bucket3 = bucket2 + bucketSize;
        int bucket4 = max - bucket3;
        
        for (Pixel dot : pixels2) // find greyscale values and set color based on bucket ranges found above
        {
            int avg = (int)((dot.getRed() + dot.getGreen() + dot.getBlue()) / 3.0);
            if (avg < bucket1)
                dot.setColor(darkblue);
            else if (avg < bucket2)
                dot.setColor(red);
            else if (avg < bucket3)
                dot.setColor(lightblue);
            else
                dot.setColor(offwhite);
        }
        danial2.explore();
    
        
        //---------------------------------------------------------------------
        /*custom color palette*/
        
        Picture danial3 = new Picture("images/danial.jpg");
        Pixel[] pixels3 = danial3.getPixels(); // create array of pixels for selfie 
        
        //make new color palette
        Color c1 = new Color(2,43,110); // range 0-51
        Color c2 = new Color(6,99,153); // range 52-103
        Color c3 = new Color(21,165,232); // range 104-155
        Color c4 = new Color(127,215,240); //range 156-207
        Color c5 = new Color(220,243,250); //range 208-255
        
        
        // find greyscale values and set colors
        for (Pixel dot : pixels3)
        {
            int avg = (int)((dot.getRed() + dot.getGreen() + dot.getBlue()) / 3.0);
            if (avg < 51)
                dot.setColor(c1);
            else if (avg < 103)
                dot.setColor(c2);
            else if (avg < 155)
                dot.setColor(c3);
            else if (avg < 207)
                dot.setColor(c4);
            else
                dot.setColor(c5);
        }
        danial3.explore();
        danial3.write("images/sf/sf3_USETHIS.jpg");
    }//main       
}//class
