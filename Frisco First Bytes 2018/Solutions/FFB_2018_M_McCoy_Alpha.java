import java.util.*;
import java.io.*;

public class FFB_2018_M_McCoy_Alpha {

   public static void main(String[] args) throws Exception {
      Scanner input = new Scanner(new File("M.txt"));
      int length = input.nextInt();
      input.nextLine();
      String[] titles = new String[length];
      for (int t = 0; t < length; t++) {
         titles[t] = input.nextLine();         
      }
      
      //bubble sort
      boolean isSorted = false;
      while (! isSorted) {
         isSorted = true;
         for (int i = 0; i < length-1; i++) {
            if (compare(titles[i], titles[i+1]) > 0) { //swap needed
               String temp = titles[i];
               titles[i] = titles[i+1];
               titles[i+1] = temp;
               isSorted = false;               
            }         
         }
      }  
      
      //print them
      for (String s : titles)
         System.out.println(s);
   }
   
   public static int compare(String a, String b) {
      a = fix(a);
      b = fix(b);
      return a.compareTo(b);
   }
   
   public static String fix(String s) {
      if (s.toLowerCase().substring(0, 2).equals("a ")) s=s.substring(2);
      else if (s.toLowerCase().substring(0, 3).equals("an ")) s=s.substring(3);
      else if (s.toLowerCase().substring(0, 4).equals("the ")) s=s.substring(4);
      s = s.replaceAll("[ -'.]", "");               
      return s.toLowerCase();
   }
  
   
}
