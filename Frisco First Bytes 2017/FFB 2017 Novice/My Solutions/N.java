import java.util.*;
import java.io.*;

public class N {

    private static BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("heroFight.txt")));

        int cases = Integer.parseInt(sc.readLine());
        for (int match = 1; match <= cases; match++) {
            String[] name = new String[2];
            name[0] = sc.readLine();
            name[1] = sc.readLine();

            int num = Integer.parseInt(sc.readLine());
            Queue<String> moves1 = new LinkedList<>();
            for (int x = 0; x < num; x++)
                moves1.add(sc.readLine());

            num = Integer.parseInt(sc.readLine());
            Queue<String> moves2 = new LinkedList<>();
            for (int x = 0; x < num; x++)
                moves2.add(sc.readLine());

            printf("Match #%d Begin!\n", match);
            for (int x = 0; !moves1.isEmpty() && !moves2.isEmpty(); x++)
                printf("%s uses %s!\n", name[(x & 1) == 0 ? 0 : 1], ((x & 1) == 0 ? moves1 : moves2).poll());
            String person, other, last;
            person = other = last = "";
            int count = 0;
            while (!moves1.isEmpty() && count++ < 2) {
                person = name[0];
                other = name[1];
                last = moves1.poll();
                printf("%s uses %s!\n", name[0], last);
            }
            while (!moves2.isEmpty() && count++ < 2) {
                person = name[1];
                other = name[0];
                last = moves2.poll();
                printf("%s uses %s!\n", name[1], last);
            }
            printf("%s defeats %s using %s!\n\n", person, other, last);
        }

        dc.close();
        sc.close();
    }

    private static void printf(String format, Object... args) throws Exception {
        dc.write(String.format(format, args));
    }
}