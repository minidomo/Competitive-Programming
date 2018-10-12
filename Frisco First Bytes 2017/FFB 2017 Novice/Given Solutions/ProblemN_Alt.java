import java.io.*;
import java.util.*;

/**
 *
 * @author Christine Peterson
 * @version 2007 Oct
 */
public class ProblemN_Alt {

    public static void main(String args[]) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File("heroFight.txt"));

        int matches = scan.nextInt();
        scan.nextLine();
        for(int m = 1; m <= matches; m++)
        {
            String hero1 = scan.nextLine();
            String hero2 = scan.nextLine();

            ArrayList<String> attacks1 = new ArrayList<>();
            ArrayList<String> attacks2 = new ArrayList<>();

            int n1 = scan.nextInt();
            scan.nextLine();
            for(int i = 0; i < n1; i++)
                attacks1.add(scan.nextLine());

            n1 = scan.nextInt();
            scan.nextLine();
            for(int i = 0; i < n1; i++)
                attacks2.add(scan.nextLine());

            System.out.println("Match #"+m+" Begin!");
            String currentAttack = "";
            while(!attacks1.isEmpty()||!attacks1.isEmpty())
            {
                if(!attacks1.isEmpty())
                {
                    currentAttack = attacks1.remove(0);
                    System.out.println(hero1+" uses "+currentAttack+"!");

                    if(attacks2.isEmpty())
                    {
                        System.out.println(hero1+" defeats "+hero2+" using "+currentAttack+"!");
                        break;
                    }
                }

                if(!attacks2.isEmpty())
                {
                    currentAttack = attacks2.remove(0);
                    System.out.println(hero2+" uses "+currentAttack+"!");
                    if(attacks1.isEmpty())
                    {
                        currentAttack = attacks2.remove(0);
                        System.out.println(hero2+" uses "+currentAttack+"!");
                        System.out.println(hero2+" defeats "+hero1+" using "+currentAttack+"!");
                        break;
                    }
                }
            }
            System.out.println();
        }
    }
}
