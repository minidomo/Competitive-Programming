import java.util.*;
import java.io.*;

public class N {

	static int ans;
	static int counter;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner input = new Scanner(new File("N.txt"));

		int objMass = input.nextInt();
		int planets = input.nextInt();
		input.nextLine();
		for (int i = 0; i < planets; i++)
		{
			String line = input.nextLine();
			String [] parts = line.split(", ");
			String name = parts[0];
			double radius = Double.parseDouble(parts[1]);
			double density = Double.parseDouble(parts[2]);


			double G = 6.67E-11;
			double planetVolume = 4/3.0 * Math.PI * Math.pow(radius, 3);
			double planetMass = planetVolume * density;
			double weight = G * objMass * planetMass / Math.pow(radius, 2);
			System.out.printf("%s: %.3f%n",name,weight);
		}


		input.close();
	}

}
