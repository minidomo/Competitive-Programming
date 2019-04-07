import java.util.*;
import java.io.*;

public class ITest {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("I.txt")));
        BufferedReader check = new BufferedReader(new InputStreamReader(new FileInputStream("I.out")));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        double fails = 0, total = 0;

        int cases = Integer.parseInt(sc.readLine());
        for (int caseNum = 1; caseNum <= cases; caseNum++) {
            String[] line = sc.readLine().split(" ");
            boolean pass = true;
            String myAnswer = "";
            String correct = check.readLine();
            boolean passedTest;
            for (int x = 1; x < line.length - 1; x++)
                if (!line[x].equals("IIII/")) {
                    pass = false;
                    break;
                }
            total++;
            if (!pass) {
                myAnswer = caseNum + " Faulty format";
                passedTest = myAnswer.equals(correct);
                if (!passedTest)
                    fails++;
                dc.write((passedTest ? "PASS" : "FAIL") + " -> " + myAnswer + " " + correct + "\n");
                continue;
            }
            String last = line[line.length - 1];
            pass = last.matches("I{1,4}") || last.equals("IIII/");
            myAnswer = caseNum + " " + (pass ? "OK " + ((line.length - 2) * 5 + last.length()) : "Faulty format");
            passedTest = myAnswer.equals(correct);
            if (!passedTest)
                fails++;
            dc.write((passedTest ? "PASS" : "FAIL") + " -> " + myAnswer + " " + correct + "\n");
        }
        dc.write("Fail Rate: " + fails / total + "\n");
        dc.close();
        sc.close();
        check.close();
    }
}