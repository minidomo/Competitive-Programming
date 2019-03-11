import java.io.*;
import java.util.*;

public class sentencestats {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = "";
        while (sc.hasNextLine())
            s += sc.nextLine() + " ";
        String[] arr = s.trim().split("[\\.!\\?]");
        int max = -1;
        int min = Integer.MAX_VALUE;
        int avg = 0;
        for (String q : arr) {
            String[] a = q.trim().split("\\s+");
            int len = a.length;
            max = Math.max(max, len);
            min = Math.min(min, len);
            avg += len;
        }
        System.out.println("# of sentences: " + arr.length);
        System.out.println("longest sentence: " + max);
        System.out.println("shortest sentence: " + min);
        System.out.println("average sentence length: " + avg / arr.length);
        sc.close();
    }
}