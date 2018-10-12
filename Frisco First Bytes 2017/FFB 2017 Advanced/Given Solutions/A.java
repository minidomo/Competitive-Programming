import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * @title Solution for Frisco FirstBytes 2017 - Problem A
 * @author Team 'BracketsDeserveTheirOwnLine' from Van High School
 */

public class A
{

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner in = new Scanner(new File("A.txt"));
		int t = toint(in.nextLine());
		while(t-->0){
			String[] inputA = in.nextLine().split(" ");
			String[] inputB = in.nextLine().split(" ");
			ArrayList<Integer> A = new  ArrayList<>();
			ArrayList<Integer> B = new  ArrayList<>();
			for(String s: inputA)
				A.add(toint(s));
			for(String s: inputB)
				B.add(toint(s));
			int lots = A.get(1);
			int money = A.get(0);
			int startI = -1, endI = -1, score = -1;
			for(int i = 0; i < B.size(); i++){
				int left = money;
				int n = 0;
				int j = i;
				for(; j < B.size() && left >= B.get(j); j++){
					left -= B.get(j);
					n++;
				}
				if(n > score){
					score = n;
					startI = i;
					endI = j;
				}
			}
				
			System.out.println(score);
		}
	}
	
	public static int toint(String s){
		return Integer.parseInt(s);
	}

}
