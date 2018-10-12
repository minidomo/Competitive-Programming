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
            String replace = "";
            int largest = -1;
            for (int x = 1; x <= min; x++) {
                String back = first.substring(first.length() - x, first.length());
                String front = second.substring(0, x);
                if (back.equals(front) && back.length() > largest) {
                    largest = back.length();
                    replace = back;
                }
            }
            dc.write(String.join("", (first + second).split(replace)) + "\n");
            dc.flush();
        }
        dc.close();
        sc.close();
    }
}