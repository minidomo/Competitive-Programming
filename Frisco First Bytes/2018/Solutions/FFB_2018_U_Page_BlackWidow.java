/**
 * Frisco First Bytes, October 2018.
 * Problem U. Black Widow
 * Beginner Category
 * 
 * @author G. Page 
 * @version 4 Oct 2018
 */
import java.util.*;
import java.io.*;

public class FFB_2018_U_Page_BlackWidow
{
    public static void main(String[] args)
        throws Exception
    {
        Scanner kb = new Scanner(System.in);
        //Scanner kb = new Scanner(new File("Z.txt"));
        
        int hgt = kb.nextInt();
        int width = 1 + ((hgt-1)*2);
        int numStarsThisLine = width;
        int numberOfSpaces = 0;
        int starCount = 0;
        
        // top half of hourglass
        int starStartPos = 0;
        for(int h=hgt; h>0; h--)
        {
            int position = 0;
            while(position < starStartPos)
            {
                System.out.print(" ");
                position++;
            }
            for(int stars=0; stars < numStarsThisLine; stars++)
            {
                System.out.print("*");
                starCount++;
            }
            System.out.println();
            starStartPos++;
            numStarsThisLine -= 2;
        }
        
        // bottom half of hourglass
        starStartPos -= 2;  //reset for bottom half
        int innerBlanks = 1;
        for(int h=hgt-2; h>0; h--)
        {
            int position = 0;
            while(position < starStartPos)
            {
                System.out.print(" ");
                position++;
            }
            System.out.print("*");
            starCount++;
            for(int blanks=0; blanks < innerBlanks; blanks++)
            {
                System.out.print(" ");
            }
            System.out.print("*");
            starCount++;
            System.out.println();
            innerBlanks += 2;
            starStartPos--;
        }
        // bottom edge of hourglass
        for(int stars=0; stars < width; stars++)
        {
            System.out.print("*");
            starCount++;
        }
        System.out.println();
        System.out.println(starCount);
    }
}
