import java.util.*;
import java.io.*;

public class CTest {

    private static double fails = 0, total = 0;
    private static String myAnswer, correct;
    private static boolean passed;
    private static BufferedWriter dc;

    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("C.txt")));
        BufferedReader check = new BufferedReader(new InputStreamReader(new FileInputStream("C.out")));
        dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int cases = Integer.parseInt(sc.readLine());
        for (int caseNum = 1; caseNum <= cases; caseNum++) {
            String[] line = sc.readLine().split(" ");
            int base = Integer.parseInt(line[1]);
            String num = Integer.toString(Integer.parseInt(line[2]), base);
            double sum = 0;
            for (char c : num.toCharArray()) {
                int a;
                if (c >= 'a' && c <= 'f')
                    a = c - 'a' + 10;
                else
                    a = Integer.parseInt(c + "");
                sum += Math.pow(a, 2);
            }
            myAnswer = caseNum + " " + (int) sum;
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