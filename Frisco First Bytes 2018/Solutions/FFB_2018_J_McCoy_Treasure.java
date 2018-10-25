import java.util.*;
import java.io.*;

public class FFB_2018_J_McCoy_Treasure {

   public static void main(String[] args) throws Exception {
      Scanner input = new Scanner(new File("J.txt"));
      int numOfCases = input.nextInt();
      input.nextLine();
      for (int caseNum = 1; caseNum <= numOfCases; caseNum++) {
         int rows = input.nextInt();
         int cols = input.nextInt();
         input.nextLine();
         int startR=0, endR=0, startC=0, endC=0;      
         for (int r = 0; r < rows; r++) {
            String line = input.nextLine();
            for (int c = 0; c < cols; c++) {
               if (line.charAt(c) == '*') {
                  startR = r;
                  startC = c;
               }
               if (line.charAt(c) == 'X') {
                  endR = r;
                  endC = c;
               }                                          
            }                          
         }
         String output = ""; 
         if (startR > endR)
            output += (startR-endR) + " north ";
         if (startR < endR)
            output += (endR-startR) + " south ";
         if (startC > endC)
            output += (startC-endC) + " west";
         if (startC < endC)
            output += (endC-startC) + " east";
         System.out.println(output);
      }
   }
}
