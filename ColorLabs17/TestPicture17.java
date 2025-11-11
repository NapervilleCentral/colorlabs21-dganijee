/**
 * Kevin Hayes
 * Test Picture Classes
 *
 * @author (Kevin Hayes)
 * @version (10-19-2016)
 */
import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
public class TestPicture17
{

    /**
     * main method, to test the picture
     *
     */
  public static void main(String[] args)
  {
      //opens picture using a dialog box
      /*
     String fileName = FileChooser.pickAFile();
     Picture pictObj = new Picture(fileName);
     pictObj.explore();
     */

     //opens a pictue using a path
     //Picture apic = new Picture("C:\\Users\\khayes\\Favorites\\Documents\APCS- Java\chap03\Curriclum 2013\Picture Color labs\images\\beach.jpg");
     
     //relative path!!!! (ON TEST)
     //                          dir/folder/file
     Picture beach = new Picture("images\\beach.jpg");
     Picture ferris1 = new Picture("images/2000 ferris wheel2.jpg");
     Picture moto = new Picture("images/redMotorcycle.jpg");
     Picture wall = new Picture("images/wall.jpg");
     //displays the picture
     //apic.explore();
     //ferris1.explore();
     //moto.explore();
     
     //makes an array of pixels
     Pixel[] pixels;
     //gets pixels from picture and assigns to pixels array
     pixels = ferris1.getPixels();
     
     Pixel[] Mpixels;
     Mpixels = moto.getPixels();
     
     Pixel[] Bpixels;
     Bpixels = beach.getPixels();
     
     Pixel[] Wpixels;
     Wpixels = wall.getPixels();
     
     //how many pixels or how large array
    System.out.println("This is a large array"+pixels.length  );
    
    int red, green, blue;
    
    /*
        //access each index
    System.out.println(pixels[17]);
    //access each pixel
    Pixel spot = ferris1.getPixel(100,100);
    Pixel spot2 = ferris1.getPixel(433,283);
    Pixel ferr17 = pixels[17];
    
    System.out.println(pixels[17].getColor());
    System.out.println(spot);
    
    Color newColor = new Color(255, 99, 71);
    
    ferr17.setRed(240);
    ferr17.setGreen(100);
    ferr17.setBlue(200);
    
    spot.setColor(newColor);
    spot2.setColor(newColor);
    //ferris1.explore();

    for (int i = 0; i < 50000; i++)
    {
        Pixel yuck = ferris1.getPixel((int)(Math.random()*1000), (int)(Math.random()*668));
        yuck.setColor(Color.orange);
    }
    ferris1.explore();
    
    /*

   // loop to access indexes of array or collection

    //for each loop spot  is a ?
    moto.explore();
    
    for (Pixel spot1 : Mpixels)
    {
        //System.out.println(spot1);
        red = spot1.getRed();
        red = (int)(red * .25);
        spot1.setRed(red);
    }
    moto.explore();
    
    for (Pixel spotb : Mpixels)
    {
        blue = spotb.getBlue();
        blue = (int)(blue * (Math.random()));
        spotb.setBlue(blue);
        
        green = spotb.getGreen();
        green = (int)(green * (Math.random()));
        spotb.setGreen(green);
    }
    moto.explore();
   
 /*
    //ADJUST RED
    moto.explore();
    for (Pixel spot1 : Mpixels)
    {
        //System.out.println(spot1);
        red = spot1.getRed();
        red = (int)(red * .25);
        spot1.setRed(red);
    }
    moto.explore();
    
    
 /*
     //NEGATE()
     beach.explore();
     for (Pixel p : Bpixels)
     {
        blue = p.getBlue();
        blue = (255 - blue);
        p.setBlue(blue);
        
        green = p.getGreen();
        green = (255 - green);
        p.setGreen(green);
        
        red = p.getRed();
        red = (255 - red);
        p.setRed(red);
     }
     beach.explore();

/*
    //GRAYSCALE()
     wall.explore();
     int avg;
     for (Pixel p : Wpixels)
     {
        blue = p.getBlue();
        green = p.getGreen();
        red = p.getRed();
        avg = (blue + green + red)/3;
        p.setBlue(avg);
        p.setGreen(avg);
        p.setRed(avg);
     }
     wall.explore();
/**/
    //DARKEN()
     wall.explore();
     int avg;
     for (Pixel p : Wpixels)
     {
        blue = p.getBlue();
        green = p.getGreen();
        red = p.getRed();
        avg = (blue + green + red)/3;
        p.setBlue(avg);
        p.setGreen(avg);
        p.setRed(avg);
     }
     wall.explore();
     
     
 /**
  * Method to clear red from picture
  * @param none
  * @return none
  */
 /*
    for (Pixel pixelObj : pixels)
        {
            //set the red value of the current pixel to the new value
           

        }
    ferris1.explore();
    
/**/
 /**
  * Method to reduce red from picture by a factor of n
  * @param none
  * @return none
  */

/*
int value;
final double  FACTOR = .5;
    for (Pixel pixelObj : pixels)
    {

        //get the redvalue
        value = pixelObj.getRed();
        //System.out.println(value);

        //decrease the red value by 50%
        
        //set the red value of the current pixel to the new value
        

    }
    // use new picture when changing or it will make changes to 
    // pic you already changed
    ferris1.explore();
    ferris2.explore();

  /**/ 
    //write/save a picture as a file
    ferris1.explore();
    ferris1.write("images/ferrisNEW.jpg");
    


    /**/
  }//main
}//class