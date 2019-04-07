import java.util.*;
import java.io.*;

public class ATest {

    private static double fails = 0, total = 0;
    private static String myAnswer, correct;
    private static boolean passed;
    private static BufferedWriter dc;

    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("A.txt")));
        BufferedReader check = new BufferedReader(new InputStreamReader(new FileInputStream("A.out")));
        dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int cases = Integer.parseInt(sc.readLine());
        for (int caseNum = 1; caseNum <= cases; caseNum++) {
            String[] line = sc.readLine().split(" ");
            int a = Integer.parseInt(line[1]);
            int b = Integer.parseInt(line[2]);
            int k = Integer.parseInt(line[3]);
            long val = Long.parseLong(line[4]);
            for (int x = k - 1; x >= 0; x--)
                val = (val - b) / a;
            myAnswer = caseNum + " " + val;
            correct = check.readLine();
            checkIfCorrect();
        }
        dc.write("Fail Rate: " + fails / total + "\n");

        dc.close();
        sc.close();
        check.close();
    }

    private static void checkIfCorrect() throws Exception {
        passed = myAnswer.equals(correct);
        if (!passed)
            fails++;
        total++;
        dc.write((passed ? "PASS" : "FAIL") + " -> " + myAnswer + " " + correct + "\n");
    }
}