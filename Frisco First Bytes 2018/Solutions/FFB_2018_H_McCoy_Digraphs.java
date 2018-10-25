import java.util.*;
import java.io.*;

public class FFB_2018_H_McCoy_Digraphs {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(new File("H.txt"));
        int numOfCases = input.nextInt();
        input.nextLine();
        String[] digraphs = {"sc", "ng", "ck", "ph", "sh", "th", "wh", "qu"};
        for (int caseNum = 1; caseNum <= numOfCases; caseNum++) {
            String phrase = input.nextLine();
            for (String dg : digraphs) {
                while (phrase.toLowerCase().indexOf(dg) > -1) { //while digraph found
                    int loc = phrase.toLowerCase().indexOf(dg);
                    phrase = phrase.substring(0, loc) + "__" + phrase.substring(loc+2);
                }         
            }
            System.out.println(phrase);
        }
    }
}
