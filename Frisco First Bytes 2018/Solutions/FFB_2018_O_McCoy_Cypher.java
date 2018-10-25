import java.util.*;
import java.io.*;

public class FFB_2018_O_McCoy_Cypher {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(new File("O.txt"));
        int numOfCases = input.nextInt();
        for (int caseNum = 1; caseNum <= numOfCases; caseNum++) {            
            int shift = input.nextInt();            
            char[] let = input.nextLine().trim().toCharArray();

            for (int i = 0; i < let.length; i++) {
                if (let[i] != ' ') {
                    let[i] += shift;
                    if (let[i] < 'A') let[i] += 26;
                    if (let[i] > 'Z') let[i] -= 26;
                }
            }

            for (char c : let)
                System.out.print(c);
            System.out.println();

        }
    }
}
