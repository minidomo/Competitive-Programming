import java.io.*;
import java.util.*;

/**
 *
 * @author Christine Peterson
 * @version 2007 Oct
 */
public class ProblemU {

    public static void main(String args[]) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File("U.txt"));
        //Scanner scan = new Scanner(System.in);

        double rate = scan.nextDouble();
        int mon = scan.nextInt();
        int tue = scan.nextInt();
        int wed = scan.nextInt();
        int thu = scan.nextInt();
        int fri = scan.nextInt();
        int sat = scan.nextInt();

        int hours = mon + tue + wed + thu + fri + sat;
        int overtimeHours = 0;
        if(hours>40)
            overtimeHours = hours - 40;
        double paycheck = hours * rate + overtimeHours * rate;
        if(sat > 0)
            paycheck += 20; //Saturday bonus

        System.out.println("$ "+paycheck);

    }
}
