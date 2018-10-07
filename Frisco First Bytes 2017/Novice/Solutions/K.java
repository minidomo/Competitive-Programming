import java.util.*;
import java.io.*;

public class K {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("snipchit.txt")));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int cases = Integer.parseInt(sc.readLine());
        while (cases-- > 0) {
            String first = sc.readLine(), second = sc.readLine();
            int min = Math.min(first.length(), second.length());
            int largest = -1;
            String replace = "";
            for (int x = 1; x <= min; x++) {
                String back = first.substring(first.length() - x, first.length());
                String front = second.substring(0, x);
                if (back.equals(front) && back.length() > largest) {
                    largest = back.length();
                    replace = back;
                }
            }
            dc.write((first + second).replace(replace, "") + "\n");
            dc.flush();
        }
        dc.close();
        sc.close();
    }
}