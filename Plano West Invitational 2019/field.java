import java.io.*;
import java.util.*;

// Solved by JB Ladera
// Solved after contest
public class field {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(), c = sc.nextInt();
        int max = 0;
        while (r-- > 0)
            for (int x = 0; x < c; x++)
                max = Math.max(max, sc.nextInt());
        System.out.println(max);
    }
}