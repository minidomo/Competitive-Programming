import java.io.*;
import java.util.*;

public class linecalculator {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        sc.nextLine();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            char c = s.charAt(0);
            int num = Integer.parseInt(s.substring(1));
            if (c == '+')
                a += num;
            else if (c == '-')
                a -= num;
            else if (c == '*')
                a *= num;
            else if (c == '/')
                a /= num;
            else
                a %= num;
        }
        System.out.println(a);
        sc.close();
    }
}