import java.util.*;
import java.io.*;

public class I {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner input = new Scanner(new File("I.txt"));
		int caseNum = 0;
		double cubeRoot = (double) 1/3;
		while (input.hasNextLine()){
			double volume = input.nextDouble();
			if (volume != 0){
				caseNum ++;

				System.out.println("Case #" + caseNum);
				double cubeLength = Math.pow(volume, cubeRoot);
				System.out.printf("Borg Cube: %.2fm length, %.2fm width, %.2fm height\n", cubeLength, cubeLength, cubeLength);
				double cylRadius = Math.pow((double) volume / (2* Math.PI), cubeRoot);
				double cylHeight = 2 * cylRadius;
				System.out.printf("Whale Cylinder: %.2fm height, %.2fm radius\n", cylHeight, cylRadius);
				double sphRadius = Math.pow((3 * volume) / (4 * Math.PI), cubeRoot);
				System.out.printf("Tholian Sphere: %.2fm radius\n", sphRadius);
				double coneRadius = Math.pow((3*volume) / (2*Math.PI), cubeRoot);
				double coneHeight = 2*coneRadius;
				System.out.printf("Remulak Cone: %.2fm height, %.2fm radius\n", coneHeight, coneRadius);


			}
			else {break;}
		}

		input.close();
	}

}
