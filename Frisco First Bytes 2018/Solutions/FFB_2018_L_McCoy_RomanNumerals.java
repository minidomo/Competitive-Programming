import java.util.*;
import java.io.*;

public class FFB_2018_L_McCoy_RomanNumerals {

   public static void main(String[] args) throws Exception {
      Scanner input = new Scanner(new File("roman.dat"));
      final String[] LETTERS = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
      final int[] NUMBERS= {1000,900,500,400,100,90,50,40,10,9,5,4,1};
   
      while (input.hasNext()) {
         String roman = input.nextLine();           
         int number=0;
         for(int i=0; i<LETTERS.length; i++)
         {
            while(roman.indexOf(LETTERS[i])==0)
            {
               number+=NUMBERS[i];
               roman=roman.substring(LETTERS[i].length());
            }
         }
         System.out.println(number);
      }
   }
}
