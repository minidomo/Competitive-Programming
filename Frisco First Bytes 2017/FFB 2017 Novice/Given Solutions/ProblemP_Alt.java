import java.io.*;
import java.util.*;

/**
 *
 * @author Christine Peterson
 * @version 2017 Sept
 */
public class ProblemP_Alt {

    public static void main(String args[]) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File("wander.txt"));

        int n = scan.nextInt();

        for(int i = 0; i < n; i++)
        {
            int r = scan.nextInt();
            int c = scan.nextInt();
            int [][] grid = new int[r][c];
            int row = -1;
            int col = -1;
            for(int rr = 0; rr < r; rr++)
                for(int cc = 0; cc < c; cc++)
                {
                    int temp = scan.nextInt();
                    if(temp == 1)
                    {
                        row = rr;
                        col = cc;
                    }
                    grid[rr][cc] = temp;
                }

            int nextValue = 2;
            int max = r * c;
            while(true)
            {
                //System.out.println("["+row+", "+col+"] "+grid[row][col]);
                if(row+1<grid.length && grid[row+1][col]==nextValue)//up
                {
                    row++;
                    nextValue++;
                }
                else if(row-1 >= 0 && grid[row-1][col]==nextValue)//down
                {
                    row--;
                    nextValue++;
                }
                else if(col+1<grid[0].length && grid[row][col+1]==nextValue)//right
                {
                    col++;
                    nextValue++;
                }
                else if(col-1 >= 0 && grid[row][col-1]==nextValue)//left
                {
                    col--;
                    nextValue++;
                }
                else
                {
                    System.out.println("No Bonus");
                    break;
                }

                if(grid[row][col] == max)
                {
                    System.out.println("Bonus");
                    break;
                }
            }
        }
    }
}
