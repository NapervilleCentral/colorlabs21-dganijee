
/**
 * Write a description of class SheparFaireyLab here.
 * 
 * @author Danial Ganijee 
 * @version 11/12/2025
 */
import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

public class SheparFaireyLab
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
        
        // set greyscale values
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
            //Color greyscale = new Color(avg,avg,avg);
            //dot.setColor(greyscale);
            
        }
        danial.explore();
        
        
        /*method 2 change (find min and max)*/
         
        /*custom color palette*/

         
    }//main       
}//class
