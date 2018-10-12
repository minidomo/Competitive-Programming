import java.io.*;
import java.util.*;

/**
 *
 * @author Christine Peterson
 * @version 2007 Oct
 */
public class ProblemT {

    public static void main(String args[]) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File("T.txt"));
        //Scanner scan = new Scanner(System.in);

        String tidbit = scan.nextLine();
        String message = scan.nextLine();

        message = message.replace(tidbit, "");
        System.out.println(message);
    }
}
