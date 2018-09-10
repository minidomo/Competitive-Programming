import java.util.*;
import java.io.*;

public class F {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("F.txt")));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int cases = Integer.parseInt(sc.readLine());
        for (int x = 1; x <= cases; x++) {
            String[] line = sc.readLine().split(" ");
            int initAmount = Integer.parseInt(line[1]);
            int maxRemove = Integer.parseInt(line[2]);
            String startingPlayer = line[3];
            boolean turn = true;
            for (int a = maxRemove; initAmount > 0; a = a == maxRemove ? 1 : maxRemove) {
                initAmount -= a;
                turn = !turn;
            }
            String myAnswer = x + " " + (!turn ? startingPlayer : (startingPlayer.equals("A") ? "B" : "A"));
            dc.write(myAnswer + "\n");
        }
        dc.close();
        sc.close();
    }
}