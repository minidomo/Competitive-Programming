
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//wow that was horrible

public class FFB_2018_N_Bunn_BowlingScores 
{
	public static void main(String[] args) throws IOException 
	{
		Scanner in = new Scanner(new File("N.txt"));

		int G = in.nextInt(); in.nextLine();

		for (int g = 0; g < G; g++) 
		{
			String[] frames = new String[10];

			for (int j = 0; j < 10; j++) //fill array with raw frame data
				frames[j] = in.next();

			int[] score = new int[10]; //will store current scores

			for (int i = 0; i < 9; i++) 
			{ 
				if (i > 0) 
					score[i] += score[i - 1];

				score[i] += getPinCount(frames[i]);                

				/*
				 * TODO so many if statements
				 */
			}
			
			for (int frame : score)
				System.out.print(frame + " ");
			
			System.out.println();
		}

		in.close();
	}

	static boolean isStrike(String frame)
	{
		return frame.charAt(0) == 'X';
	}

	static boolean isSpare(String frame)
	{
		return frame.charAt(1) == '/';
	}

	static int getPinCount(String frame)
	{
		int first = 0, second = 0;

			if (isStrike(frame))
				first = 10;

			else if (isSpare(frame)) {
				first  = Integer.parseInt(frame.substring(0, 1));
				second = 10 - first;
			}

			else {
				try { first  = Integer.parseInt(frame.substring(0, 1)); } catch (NumberFormatException e) {}
				try { second = Integer.parseInt(frame.substring(1, 2)); } catch (NumberFormatException e) {}
			}

		return first + second;
	}

	static int getPinCountTenth(String frame)
	{
		int firstAndSecond = getPinCount(frame);

		int third = 0;

		try {
			if (frame.charAt(2) == 'X')
				third = 10;
			else
				third = Integer.parseInt(frame.substring(2, 3));
		}
		catch (NumberFormatException | StringIndexOutOfBoundsException e) {}

		return firstAndSecond + third;
	}
	
//	public static void main(String[] args) {
//		System.out.println(getPinCount("-5"));
//		System.out.println(getPinCount("8/"));
//		System.out.println(getPinCount("X"));
//		System.out.println(getPinCountTenth("9/5"));
//		System.out.println(getPinCountTenth("XXX"));
//	}
}
