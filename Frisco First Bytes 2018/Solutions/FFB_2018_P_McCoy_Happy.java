import java.util.*;
import java.io.*;

public class FFB_2018_P_McCoy_Happy {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(new File("P.txt"));
        int numOfCases = input.nextInt();
        for (int caseNum = 1; caseNum <= numOfCases; caseNum++) {
            int num = input.nextInt();
            ArrayList<Integer> list = new ArrayList<Integer>();            
            list.add(num);
            boolean happy = true; //assume happy
            while (num != 1 && happy) {
                num = nextNum(num);
                if (list.contains(num))
                    happy = false;      
                else
                    list.add(num);
            }
            if (happy)
                System.out.println(list.get(0) + " is happy");
            else 
                System.out.println(list.get(0) + " is sad");                
        }
    }
    
    public static int nextNum(int n) {
        int sum = 0;
        while (n > 0) {        
            int digit = n%10;
            sum += digit*digit;
            n /= 10;
        }
        return sum;
    }
}
