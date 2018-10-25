
import java.io.*;
import java.util.*;


/**
 *
 * @author Christine Peterson
 * @version 2018
 */
public class FFB_2018_H_Peterson_Digraphs {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("H.txt"));
        int N = scan.nextInt();
        scan.nextLine();
        
        for(int i = 0; i < N; i++)
        {
            String line = scan.nextLine();
            
            line = line.replaceAll("sc|ng|ck|ph|sh|th|wh|qu", "__");
            line = line.replaceAll("SC|NG|CK|PH|SH|TH|WH|QU", "__");
            line = line.replaceAll("Sc|Ng|Ck|Ph|Sh|Th|Wh|Qu", "__");
            line = line.replaceAll("sC|nG|cK|pH|sH|tH|wH|qU", "__");
            
            System.out.println(line);
        }
        
    }
    
}
