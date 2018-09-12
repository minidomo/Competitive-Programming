import java.util.*;
import java.io.*;

public class BTest {

    private static double fails = 0, total = 0;
    private static String myAnswer, correct;
    private static boolean passed;
    private static BufferedWriter dc;

    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("B.txt")));
        BufferedReader check = new BufferedReader(new InputStreamReader(new FileInputStream("B.out")));
        dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int cases = Integer.parseInt(sc.readLine());
        for (int caseNum = 1; caseNum <= cases; caseNum++) {
            int days = Integer.parseInt(sc.readLine().split(" ")[1]);
            // gauss formula
            myAnswer = caseNum + " " + ((days * (days + 1)) / 2 + days);
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