
/**
 * Write a description of class TestPicture here.
 *
 * @author Dan
 * @version (a version number or a date)
 */

import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
public class TestPicture
{
    
    public static void main(String[] args)
    {
        Picture bron = new Picture("images\\bron.jpg");
        Picture canvas = new Picture("images\\canvas.jpg");
        
        mirrorVertical(bron);
        bron.explore(); //displays picture
        
        copytoCanvas(bron, canvas);
        canvas.explore();
    }
    
    /**
     * Method to mirror around a vertical line in the middle of the picture based on the width
     */
    public static Picture mirrorVertical(Picture apic)
    {
        int width = apic.getWidth();
        int mirrorPoint = width/2;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        
        
        // loop through all the rows
        for (int y = 0; y < apic.getHeight(); y++)
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
    
    /**
     * Add two ints to the parameters and that's the place you want target to go onto the canvas
     */
    public static void copytoCanvas(Picture source, Picture target)
    {
        Pixel sourcePix = null;
        Pixel targetPix = null;
        
        // loop through the columns (targetX is starting point on Canvas)
        for (int sourceX = 0, targetX = 0; sourceX < source.getWidth(); sourceX++, targetX++)
        {
            // loop through the rows
            for (int sourceY = 0, targetY = 0; sourceY < source.getHeight(); sourceY++, targetY++)
            {
                sourcePix = source.getPixel(sourceX, sourceY);
                targetPix = target.getPixel(targetX, targetY);
                targetPix.setColor(sourcePix.getColor());
            }
        }
        
    }
}
