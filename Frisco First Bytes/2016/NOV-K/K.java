import java.util.*;
import java.io.*;

public class K {

	static int ans;
	static int counter;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner input = new Scanner(new File("K.txt"));

		int n = input.nextInt();

		for(int i = 0; i < n; i++)
		{
			int [] cards = new int[8];
			for(int j = 0; j < 8; j++)
			{
				int k =  input.nextInt()%13;
				if(k == 0)
					k = 13;
				cards[j] = k;
			}
			//System.out.println(Arrays.toString(cards));

			//Kronk
			if(cards[7]==13 ||
				cards[7]==12 ||
				cards[7]==11 ||
				cards[7]==1 ||
				cards[7]==2 ||
				cards[7]==4 ||
				cards[7]==6 ||
				cards[7]==8	)
			{
				System.out.println("KRONK! Scotty beams us up!");
				continue;
			}

			int aces = 0;
			int twos = 0;
			int sixes = 0;
			int jacks = 0;
			int queens = 0;
			int kings = 0;
			for(int j = 0; j < 8; j++)
			{
				if(cards[j]==1)
					aces++;
				if(cards[j]==2)
					twos++;
				if(cards[j]==6)
					sixes++;
				if(cards[j]==11)
					jacks++;
				if(cards[j]==12)
					queens++;
				if(cards[j]==13)
					kings++;
			}
			//Royal Fizzbin
			if(aces == 2 && twos == 1 && 6 == 1 && queens == 2 && jacks == 1 && kings == 1)
			{
				System.out.println("Royal Fizzbin");
				continue;
			}
			//Disqualified
			if(jacks >= 3 || queens >=3 || kings >= 3)
			{
				System.out.println("Disqualified");
				continue;
			}
			//Half-Fizzbin
			if(jacks == 2 || queens == 2 || kings == 2 )
			{
				System.out.println("Half-Fizzbin");
				continue;
			}
			System.out.println("Nothing");
		}
		input.close();
	}

}
