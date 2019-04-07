import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class E {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(new File("E.txt"));
		int n = s.nextInt();
		for(int i=0;i<n;i++){
			int W = s.nextInt();
			int L = s.nextInt();
			int squares = 0;
			while(true){
				if(L>=W){
					squares+=1;
					L=L-W;
				}
				else if(W>=L){
					squares+=1;
					W=W-L;
				}
				if(L==0 || W==0){
					break;
				}
			}
			System.out.println(squares);
		}

	}

}