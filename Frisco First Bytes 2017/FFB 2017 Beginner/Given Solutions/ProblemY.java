import java.io.*;
import java.util.*;

/**
 *
 * @author Christine Peterson
 * @version 2007 Oct
 */
public class ProblemY {

    public static void main(String args[]) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File("Y.txt"));
        //Scanner scan = new Scanner(System.in);

        int papaya = 0;
        int passionFruit = 0;
        int peach = 0;
        int pineapple = 0;
        int pals = scan.nextInt();
        scan.nextLine();
        for(int i = 0; i < pals; i++)
        {
            String fruit = scan.nextLine();
            switch(fruit)
            {
                case "papaya":
                    papaya++;
                    break;
                case "passion fruit":
                    passionFruit++;
                    break;
                case "peach":
                    peach++;
                    break;
                case "pineapple":
                    pineapple++;
            }
        }
        System.out.println(papaya+" papaya");
        System.out.println(passionFruit+" passion fruit");
        System.out.println(peach+" peach");
        System.out.println(pineapple+" pineapple");
    }
}
