
import java.io.*;
import java.util.*;


/**
 *
 * @author Mrs.Peterson 
 * @version Sept 2018
 */
public class FFB_2018_B_Peterson_OrderUp {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("B.txt"));
        
        int N = sc.nextInt();
        sc.nextLine();
        while(N!=0)
        {
            ArrayList<String> names = new ArrayList<>();
            for(int i = 0; i < N ; i++)
            {
                String name = sc.nextLine();
                //System.out.println(name);
                boolean isInserted = false;
                for(int j = 0; j < names.size(); j++)
                {
                    if(names.get(j).substring(0,2).compareTo(name.substring(0,2))>0){
                        names.add(j,name);
                        isInserted = true;
                        break;
                    }
                }
                if(!isInserted)
                    names.add(name);
            }
            for(String nam: names)
                System.out.println(nam);
            System.out.println();
            N = sc.nextInt();
            sc.nextLine();  
        }
    }
}
