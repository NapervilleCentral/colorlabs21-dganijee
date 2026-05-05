
/**
 * My Final Project Picture Collage
 *
 * @author Dan
 * @version 5/5/2026
 */

import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
public class Collage
{
    
    public static void main(String[] args)
    {
        Picture bron = new Picture("images\\collage\\bron.jpg");
        Picture canvas = new Picture("images\\collage\\canvas.jpg");
        
        // pic 1, mirror around vertical point
        mirrorVertical(bron);
        copytoCanvas(bron, canvas);
        //bron.write("mirroredLeBron1");
        
        // pic 2,blend with Micheal Jordan
        blend(new Picture("images\\collage\\goat.jpg");
        
        copytoCanvas(bron, canvas);
        canvas.explore();
    }
    
    /**
     * Blend method (copy every other pixel and display MJ in the back)
     * @param new Picture to blend with LeBron
     */
    public static Picture blend(Picture newp)
    {
        int width = pic.getWidth();
        
        // loop through all the rows
        for (int y = 0; y < pic.getHeight(); y++)
        {
            // loop through all columns
            for (int x = 0; x < width; x++)
            {
                leftPixel = pic.getPixel(x,y);
                rightPixel = pic.getPixel(width - 1 - x, y);
                rightPixel.setColor(leftPixel.getColor());
                
            }
        }
        
        return pic;
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
    
    /**
     * Add two ints to the parameters and that's the place you want target to go onto the canvas
     */
    public static void copytoCanvasSmaller(Picture source, Picture target) 
    {
        // recursion copy to a x,y on the source
        Pixel sourcePix = null;
        Pixel targetPix = null;
        
        // loop through the columns (targetX is starting point on Canvas) sourceX+=2 for make smaller, sourceX+0.5 for make larger
        for (int sourceX = 0, targetX = 0; sourceX < source.getWidth(); sourceX+=2, targetX++)
        {
            // loop through the rows                                        sourceY+=2 for make smaller, sourceY+0.5 for make larger
            for (int sourceY = 0, targetY = 0; sourceY < source.getHeight(); sourceY+=2, targetY++)
            {
                sourcePix = source.getPixel(sourceX, sourceY);
                targetPix = target.getPixel(targetX, targetY);
                targetPix.setColor(sourcePix.getColor());
            }
        }
        
    }
}
