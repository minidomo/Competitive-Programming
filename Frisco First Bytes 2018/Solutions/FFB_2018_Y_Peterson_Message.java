
import java.io.*;
import java.util.*;

/**
 *
 * @author Mrs.Peterson
 * @version Sept 2018
 */
public class FFB_2018_Y_Peterson_Message {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("Y.txt"));
        String s = sc.nextLine();
        String ss = "";
        for(int i = 0; i < s.length()/2*2; i+=2)
        {
            String t = s.substring(i, i+1);
            String u = s.substring(i+1, i+2);
            ss += u + t;
        }
        if(s.length()%2!=0)
            ss+=s.substring(s.length()-1);
        System.out.println(ss);

    }
}
