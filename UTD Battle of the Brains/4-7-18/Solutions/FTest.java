import java.util.*;
import java.io.*;

public class FTest {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("F.txt")));
        BufferedReader check = new BufferedReader(new InputStreamReader(new FileInputStream("F.out")));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int failRate = 0;
        double total = 0;

        int cases = Integer.parseInt(sc.readLine());
        for (int x = 1; x <= cases; x++) {
            String[] line = sc.readLine().split(" ");
            int initAmount = Integer.parseInt(line[1]);
            int maxRemove = Integer.parseInt(line[2]);
            String startingPlayer = line[3];
            // could be simplified to:
            // String myAnswer = "";
            // if (initAmount % (maxRemove + 1) != 0)
            // myAnswer = x + " " + startingPlayer;
            // else
            // myAnswer = x + " " + (startingPlayer.equals("A") ? "B" : "A");
            boolean turn = true;
            for (int a = maxRemove; initAmount > 0; a = a == maxRemove ? 1 : maxRemove) {
                initAmount -= a;
                turn = !turn;
            }
            String myAnswer = x + " " + (!turn ? startingPlayer : (startingPlayer.equals("A") ? "B" : "A"));
            String correct = check.readLine();
            boolean pass = myAnswer.equals(correct);
            dc.write(x + " " + (pass ? "PASS" : "FAIL") + " -> " + myAnswer + " " + correct + "\n");
            if (!pass)
                failRate++;
            total++;
            
        }
        dc.write("Fail Rate: " + failRate / total + "\n");

        dc.close();
        sc.close();
        check.close();
    }
}