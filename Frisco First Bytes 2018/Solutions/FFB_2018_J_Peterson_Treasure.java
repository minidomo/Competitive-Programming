
import java.io.*;
import java.util.*;


/**
 *
 * @author Christine Peterson
 * @version 2018
 */
public class FFB_2018_J_Peterson_Treasure {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("J.txt"));
        
        int N = scan.nextInt();
        scan.nextLine();
        
        for(int i = 0 ; i < N; i++)
        {
            int R = scan.nextInt();
            int C = scan.nextInt();
            scan.nextLine();
            int startRow = -1;
            int startCol = -1;
            int endRow = -1;
            int endCol = -1;
            for(int r = 0 ; r < R; r++)
            {
                String row = scan.nextLine();
                for(int c = 0 ; c < C; c++)
                {
                    if(row.charAt(c)=='X')
                    {
                        endRow = r;
                        endCol = c;
                    }
                    if(row.charAt(c)=='*')
                    {
                        startRow = r;
                        startCol = c;
                    }
                }
            }
            String ans = "";
            if(endRow>startRow)
            {
                ans += (Math.abs(endRow-startRow))+" south ";
            }
            if(endRow<startRow)
            {
                ans += (Math.abs(endRow-startRow))+" north ";
            }
            if(endCol>startCol)
            {
                ans += (Math.abs(endCol-startCol))+" east";
            }
            if(endCol<startCol)
            {
                ans += (Math.abs(endCol-startCol))+" west";
            }
            System.out.println(ans.trim());
        }
    }
}
