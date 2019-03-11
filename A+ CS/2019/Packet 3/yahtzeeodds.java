import java.io.*;
import java.util.*;

public class YahtzeeOdds {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] arr = sc.nextLine().split("[,\\s]");
            int count = 0;
            String s = arr[5].substring(1, arr[5].length() - 1);
            for (int x = 0; x < arr.length - 1; x++)
                if (!arr[x].equals(s))
                    count++;
            System.out.println("1 in " + (int) Math.pow(6, count));
        }
        sc.close();
    }
}