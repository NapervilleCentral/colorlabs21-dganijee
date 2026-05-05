
/**
 * Write a description of class Parthenon here.
 *
 * @author Dan
 * @version 5/5/2026
 */

import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
public class Parthenon
{
    
    public static void main(String[] args)
    {
        Picture parthenon = new Picture("images\\temple.jpg");
        
        mirrorVertical(parthenon);
        parthenon.explore(); //displays picture
        
    }
    
    /**
     * Method to mirror around a vertical line in the middle of the picture based on the width
     */
    public static Picture mirrorVertical(Picture apic)
    {
        int width = apic.getWidth();
        int mirrorPoint = 568;
        Pixel leftPixel = new Pixel(apic,16,97);
        Pixel rightPixel = new Pixel(apic,540,97);
        
        
        // loop through all the rows
        for (int y = 0; y < 98; y++)
        {
            // loop from 0 to the middle (mirror point)
            for (int x = 0; x < mirrorPoint; x++)
            {
                leftPixel = apic.getPixel(x,y);
                rightPixel = apic.getPixel(width - 1 - x, y);
                rightPixel.setColor(leftPixel.getColor());
                
            }
        }
        
        return apic;
    }
    
}
