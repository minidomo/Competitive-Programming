import java.util.*;
import java.io.*;

public class I {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("I.txt")));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int cases = Integer.parseInt(sc.readLine());
        for (int caseNum = 1; caseNum <= cases; caseNum++) {
            String[] line = sc.readLine().split(" ");
            boolean pass = true;
            for (int x = 1; x < line.length - 1; x++)
                if (!line[x].equals("IIII/")) {
                    pass = false;
                    break;
                }
            if (!pass) {
                dc.write(caseNum + " Faulty format\n");
                continue;
            }
            String last = line[line.length - 1];
            pass = last.matches("I{1,4}") || last.equals("IIII/");
            dc.write(caseNum + " " + (pass ? "OK " + ((line.length - 2) * 5 + last.length()) : "Faulty format") + "\n");
        }
        dc.close();
        sc.close();
    }
}