
/**
 * My Final Project Picture Collage
 *
 * @author Dan Ganijee
 * @version 5/5/2026
 */

import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

public class Collage
{
    
    public static void main(String[] args)
    {
        Picture canvas = new Picture("images\\collage\\canvas.jpg");
        
        // ------pic 1, mirror around vertical point------
        Picture bron1 = new Picture("images\\collage\\bron.jpg");
        mirrorVertical(bron1);
        copytoCanvas(0,0,bron1, canvas);
        //bron1.write("mirroredLeBron1");
        
        // ------pic 2,blend with goat------
        Picture bron2 = new Picture("images\\collage\\bron.jpg");
        blend(bron2, new Picture("images\\collage\\goat.jpg"));
        copytoCanvas(bron2.getWidth(),0, bron2, canvas);
        //bron2.write("blendedLeBron2");
        
        // ------pic 3, shephard fairey------
        Picture bron3 = new Picture("images\\collage\\bron.jpg");
        shephard(bron3);
        copytoCanvas(bron3.getWidth() * 2, 0, bron3, canvas);
        //bron3.write("rainbowLeBron3");
        
        // ------pic 4, recursion (top left)------
        Picture bron4 = new Picture("images\\collage\\bron.jpg");
        recursive(bron4);
        copytoCanvas(0, bron4.getHeight(), bron4, canvas);
        //bron4.write("recursiveLeBron4");
        
        // ------pic 5, rotate bron 180 degrees------
        Picture bron5 = new Picture("images\\collage\\bron.jpg");
        rotate180(bron5);
        copytoCanvas(bron5.getWidth(), bron5.getHeight(), bron5, canvas);
        //bron5.write("recursiveLeBron4");
        
        canvas.explore();
    }
    
    /**
     * Rotates bron 180 degrees by swapping each pixel with the other pixel at the opposite corner
     * @param bron picture obj
     * @return the rotated bron picture
     */
    public static Picture rotate180(Picture bron)
    {
        int width = bron.getWidth();
        int height = bron.getHeight();
        
        // only loop through half the pixels since we'd swap them back if we looped through all
        for(int y = 0; y < (height/2); y++) // look through rows
        {
            for (int x = 0; x < (width/2); x++) // look through columns
            {
                Pixel topPix = bron.getPixel(x,y);
                Pixel bottomPix = bron.getPixel(width - 1 - x, height - 1 - y);
                
                Color temporary = topPix.getColor();
                topPix.setColor(bottomPix.getColor());
                bottomPix.setColor(temporary);
            }
        }
        
        return bron;
    }
    
    /**
     * Recursive function (will keep overlapping a smaller picture in the top left)
     * @param LeBron picture obj
     * @return recursive LeBron pic
     */
    public static Picture recursive(Picture bron)
    {
        int width = bron.getWidth();
        int height = bron.getHeight();
        
        // base case (if the bron pic is too small to shrink) picture bigger
        if (width < 2 || height < 2)
        {
            return bron;
        }
        
        // make a half-sized bron pic
        Picture small = new Picture(width/2, height/2);
        
        for(int y = 0; y < (height/2); y++) // look through rows
        {
            for (int x = 0; x < (width/2); x++) // look through columns
            {
                Color color = bron.getPixel(x*2, y*2).getColor(); // copy every other pixel from bron and get its color
                small.getPixel(x,y).setColor(color); // set the smaller pic's pixel color to that color
            }
        }
        
        // call function again on the small copy
        recursive(small);
        copytoCanvas(0,0,small,bron); // i basically made my own canvas using the original pic as the canvas
        
        return bron;
    }
    
    /**
     * Rainbow shephard fairey (take the greyscale average of the current pixel and then display a ROYGBV in the range)
     * @param main picture
     * @return modified main picture
     */
    public static Picture shephard(Picture bron)
    {
        Pixel[] pixels; pixels = bron.getPixels(); // create array of pixels
        Color red = new Color(255,0,0);
        Color orange = new Color(255,151,0);
        Color yellow = new Color(251,255,95);
        Color green = new Color(0,255,1);
        Color blue = new Color(0,169,255);
        Color purple = new Color(217,153,255);
        Color pink = new Color(255,208,246);
        for (Pixel spot : pixels)
        {
            int avg = (int)((spot.getRed() + spot.getGreen() + spot.getBlue()) / 3.0);
            if (avg < 36)
                spot.setColor(red);
            else if (avg < 72)
                spot.setColor(orange);
            else if (avg < 108)
                spot.setColor(yellow);
            else if (avg < 144)
                spot.setColor(green);
            else if (avg < 180)
                spot.setColor(blue);
            else if (avg < 216)
                spot.setColor(purple);
            else
                spot.setColor(pink);
        }
        
        return bron;
    }
    
    /**
     * Blend method (overwrite the color of every other pixel)
     * @param main picture, new Picture to blend with main picture
     * @return blended main picture
     */
    public static Picture blend(Picture bron, Picture newp)
    {
        int width = bron.getWidth();
        
        // loop through all the rows
        for (int y = 0; y < bron.getHeight(); y++)
        {
            // loop through all columns
            for (int x = 0; x < width; x+=2) // every other pixel for blend effect
            {
                Pixel replace = bron.getPixel(x,y);
                Color color = (newp.getPixel(x,y)).getColor();
                replace.setColor(color);
            }
        }
        
        return bron;
    }
    
    /**
     * Method to mirror around a vertical line in the middle of the picture based on the width
     * @param main picture
     * @return mirrored main picture
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
     * Overloaded Method, can choose mirror point manually
     */
    public static Picture mirrorVertical(Picture apic, int MirrorPoint)
    {
        int width = apic.getWidth();
        int mirrorPoint = MirrorPoint;
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
    public static void copytoCanvas(int x, int y, Picture source, Picture target)
    {
        Pixel sourcePix = null;
        Pixel targetPix = null;
        
        // loop through the columns (targetX is starting point on Canvas)
        for (int sourceX = 0, targetX = x; sourceX < source.getWidth(); sourceX++, targetX++)
        {
            // loop through the rows
            for (int sourceY = 0, targetY = y; sourceY < source.getHeight(); sourceY++, targetY++)
            {
                sourcePix = source.getPixel(sourceX, sourceY);
                targetPix = target.getPixel(targetX, targetY);
                targetPix.setColor(sourcePix.getColor());
            }
        }
        
    }
        
    }

