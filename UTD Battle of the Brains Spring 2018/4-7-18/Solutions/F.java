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
            // could be simplified to:
            // if (initAmount % (maxRemove + 1) != 0)
            // dc.write(x + " " + startingPlayer + "\n");
            // else
            // dc.write(x + " " + (startingPlayer.equals("A") ? "B" : "A") + "\n");
            boolean turn = true;
            for (int a = maxRemove; initAmount > 0; a = a == maxRemove ? 1 : maxRemove) {
                initAmount -= a;
                turn = !turn;
            }
            dc.write(x + " " + (!turn ? startingPlayer : (startingPlayer.equals("A") ? "B" : "A")) + "\n");
        }
        dc.close();
        sc.close();
    }
}