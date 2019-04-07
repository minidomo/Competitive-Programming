
import java.io.*;
import java.util.*;


/**
 *
 * @author Mrs.Peterson 
 * @version Sept 2018
 */
public class FFB_2018_K_Peterson_FinancialForensics {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("K.txt"));
        int n = sc.nextInt();
        sc.nextLine();
        
        for(int i = 0; i < n; i++)
        {
            String acct = sc.nextLine();
            String transactions = sc.nextLine();
            Scanner tsc = new Scanner(transactions);
            int ones = 0;
            int nines = 0;
            double count = 0;
            while(tsc.hasNext())
            {
                String num = tsc.next();
                if(num.charAt(0)=='1')
                    ones++;
                if(num.charAt(0)=='9')
                    nines++;
                count++;
            }
            System.out.print(acct + " ");
            double perOnes = ones/count;
            double perNines = nines/count;
            if(perOnes<.25 || perNines >.10)
                System.out.println("MUST BE INVESTIGATED FURTHER.");
            else
                System.out.println("MEETS BENFORD'S LAW.");
        }
    }
}
