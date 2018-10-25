
import java.io.*;
import java.util.*;


/**
 *
 * @author Christine Peterson
 * @version 2018
 */
public class FFB_2018_M_Peterson_Alphabetize {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("M.txt"));
        
        ArrayList<Title> titles = new ArrayList<>();
        
        int N = scan.nextInt();
        scan.nextLine();
        for(int i = 0; i < N; i++)
            titles.add(new Title(scan.nextLine()));
        
        Collections.sort(titles);
        for(Title t: titles)
            System.out.println(t.title);
    }
    
    static class Title implements Comparable
    {
        String title;
        String sortable;

        public Title(String title) {
            this.title = title;
            sortable = title.toLowerCase();
            
            sortable = sortable.replaceFirst("the ", "");
            sortable = sortable.replaceFirst("a ", "");
            sortable = sortable.replaceFirst("an ", "");
            
            sortable = sortable.replaceAll("[^a-z ]", "");
        }

        @Override
        public int compareTo(Object t) {
            return this.sortable.compareTo(((Title)t).sortable);
        }
    }
}
