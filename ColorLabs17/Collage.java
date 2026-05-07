
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
        //bron1.write("images\\collage\\mirroredLeBron1.jpg");
        
        // ------pic 2,blend with goat------
        Picture bron2 = new Picture("images\\collage\\bron.jpg");
        blend(bron2, new Picture("images\\collage\\goat.jpg"));
        copytoCanvas(bron2.getWidth(),0, bron2, canvas);
        //bron2.write("images\\collage\\blendedLeBron2.jpg");
        
        // ------pic 3, shephard fairey------
        Picture bron3 = new Picture("images\\collage\\bron.jpg");
        shephard(bron3);
        copytoCanvas(bron3.getWidth() * 2, 0, bron3, canvas);
        //bron3.write("images\\collage\\rainbowLeBron3.jpg");
        
        // ------pic 4, recursion (top left)------
        Picture bron4 = new Picture("images\\collage\\bron.jpg");
        recursive(bron4);
        copytoCanvas(0, bron4.getHeight(), bron4, canvas);
        //bron4.write("images\\collage\\recursiveLeBron4.jpg");
        
        // ------pic 5, rotate 180 degrees------
        Picture bron5 = new Picture("images\\collage\\bron.jpg");
        rotate180(bron5);
        copytoCanvas(bron5.getWidth(), bron5.getHeight(), bron5, canvas);
        //bron5.write("images\\collage\\rotate180LeBron5.jpg");
        
        // ------pic 6, blue tinted ------
        Picture bron6 = new Picture("images\\collage\\bron.jpg");
        bluetint(bron6);
        copytoCanvas(2*bron6.getWidth(), bron6.getHeight(), bron6, canvas);
        //bron6.write("images\\collage\\bluetintLeBron6.jpg");
        
        // ------pic 7, edge detection ------
        Picture bron7 = new Picture("images\\collage\\bron.jpg");
        edge(bron7,5);
        copytoCanvas(0, 2* bron6.getHeight(), bron7, canvas);
        //bron7.write("images\\collage\\edgeDetectionLeBron7.jpg");
        
        // ------pic 8, pixelate ------
        Picture bron8 = new Picture("images\\collage\\bron.jpg");
        pixelate(bron8,20);
        copytoCanvas(bron8.getWidth(), 2* bron6.getHeight(), bron8, canvas);
        //bron8.write("images\\collage\\pixelateLeBron8.jpg");
        
        // ------pic 9, negate ------
        Picture bron9 = new Picture("images\\collage\\bron.jpg");
        negate(bron9);
        copytoCanvas(2*bron9.getWidth(), 2* bron9.getHeight(), bron9, canvas);
        //bron9.write("images\\collage\\negateLeBron9.jpg");
        
        canvas.explore();
    }
    
    /**
     * Negate -- flips every color to its opposite (255 - value)
     * @param bron pic
     * @return negated bron pic
     */
    public static Picture negate(Picture bron)
    {
        Pixel[] pixels = bron.getPixels();
        
        for (Pixel spot : pixels)
        {
            spot.setRed(255-spot.getRed());
            spot.setGreen(255-spot.getGreen());
            spot.setBlue(255-spot.getBlue());
        }
        
        return bron;
    }
    
    /**
     * Pixelate
     * What it is: break off the picture into square sections and fill each square with one solid color
     * For simplicity i decided to take top left pixel's color.
     * @param bron pic
     * @param squareSize (how big is the square section, bigger means more pixelated)
     * @return pixelated bron
     */
    public static Picture pixelate(Picture bron, int squareSize)
    {
        int width = bron.getWidth();
        int height = bron.getHeight();
        
        // outer loops iterate by squareSize so it can reach every block's top left pixel so it can get the color
        for (int squareY = 0; squareY < height; squareY += squareSize)
        {
            for (int squareX = 0; squareX < width; squareX += squareSize)
            {
                // get the top left pixels color
                Color color = bron.getPixel(squareX, squareY).getColor();
                
                // copy that color to every pixel in that square
                // loop conditions make sure that the pixel is within the block
                for (int y = squareY; y < squareY + squareSize && y < height; y++)
                {
                    for (int x = squareX; x < squareX + squareSize && x < width; x++)
                    {
                        bron.getPixel(x,y).setColor(color);
                    }
                }
                
            }
        }
        
        return bron;
    }
    
    /**
     * Edge detection
     * What it is: compares each pixels avg RGB val to the one below it. If similar, paint the top pixel white. If different,
     * paint it black. 
     * @param lebron picture
     * @return edge detected lebron
     */
    public static Picture edge(Picture bron, double amount) // amount changes the threshhold between similar/different
    {
        int width = bron.getWidth();
        int height = bron.getHeight();
        
        // since we compare every bottom pixel, don't compare to bottom row otherwise it'll mess up the pic
        for (int y = 0; y < height - 1; y++) // look through rows
        {
            for (int x = 0; x < width; x++) //look through columns
            {
                // get both bottom and top pixel
                Pixel topPix = bron.getPixel(x,y);
                Pixel bottomPix = bron.getPixel(x,y+1);
                
                // calculate average RGB value
                double topVal = (topPix.getRed() + topPix.getGreen() + topPix.getBlue())/3.0;
                double bottomVal = (bottomPix.getRed() + bottomPix.getGreen() + bottomPix.getBlue())/3.0;
                
                //find the difference
                double difference = Math.abs(topVal - bottomVal); // don't want negative numbers, messes up picture
                
                // compare difference to amount the user set (i can play with this value to get the best result)
                if (difference < amount)
                    topPix.setColor(Color.WHITE);
                else
                    topPix.setColor(Color.BLACK);
            }
        }
        
        return bron;
    }
    
    /**
     * bluetint - adds a blue tint to lebron picture by boosting the B value and reducing the R and G value of each pixel
     * @param lebron pic
     * @return bluetinted lebron pic
     */
    public static Picture bluetint(Picture bron)
    {
        Pixel[] pixels = bron.getPixels();
        for (Pixel spot:pixels)
        {
            spot.setRed((int)(spot.getRed() * 0.5)); // cut red in half
            spot.setGreen((int)(spot.getGreen() * 0.5)); // same thing with green
            spot.setBlue((int)(spot.getBlue() * 1.5)); // increase blue
        }
        
        return bron;
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
            for (int x = 0; x < width; x++) // look through columns
            {
                Pixel topPix = bron.getPixel(x,y);
                Pixel bottomPix = bron.getPixel(width - 1 - x, height - 1 - y); //-1 for n-1 correct index
                
                // swap the colors over
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

