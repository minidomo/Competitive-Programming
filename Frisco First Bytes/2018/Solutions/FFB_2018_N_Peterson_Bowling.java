
import java.io.*;
import java.util.*;

/**
 *
 * @author Christine Peterson
 * @version 2018
 */
public class FFB_2018_N_Peterson_Bowling {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("N.txt"));

        int N = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < N; i++) {
            String line = scan.nextLine();
            line = line.replace("-", "0");

//            System.out.println(line);
            String[] frames = line.split(" ");
//            System.out.println(Arrays.toString(frames));
            int[] frameScores = new int[10];

            for (int j = 0; j < 10; j++) //each frame
            {
                for (int k = 0; k < frames[j].length(); k++) {
                    String digit = frames[j].substring(k, k + 1);  //roll string
                    if (digit.equals("X")) {  //STRIKE!!!
                        frameScores[j] += 10;
                        
                        //Identify next 2 rolls
                        String nextRollStr = "";
                        String nextNextRollStr = "";
                        if (j == 9) //10th frame
                        {
                            nextRollStr = frames[j].substring(1, 2); //2nd roll
                            nextNextRollStr = frames[j].substring(2, 3); //3rd roll

                        } else if (j == 8) {
                            nextRollStr = frames[j+1].substring(0, 1); //2nd roll
                            nextNextRollStr = frames[j+1].substring(1, 2); //3rd roll
                        }
                        else 
                        {
                            String combinedFrames = frames[j+1] + frames[j+2];
                            nextRollStr = combinedFrames.substring(0, 1); //2nd roll
                            nextNextRollStr = combinedFrames.substring(1, 2); //3rd roll
                        }
                        
                        //Add next roll
                        if (nextRollStr.equals("X")) {
                            frameScores[j] += 10;
                        } else {
                            frameScores[j] += Integer.parseInt(nextRollStr);
                        }
                        
                        //Add next next roll
                        if (nextNextRollStr.equals("X")) {
                            frameScores[j] += 10;
                        } else if (nextNextRollStr.equals("/")) {
                            frameScores[j] += 10 - Integer.parseInt(nextRollStr);
                        } else {
                            frameScores[j] += Integer.parseInt(nextNextRollStr);
                        }
                        
                        if (j == 9) {
                            break;
                        }
                    } else if (digit.equals("/")) {  //SPARE!!!
                        int prev = Integer.parseInt(frames[j].substring(k - 1, k));
                        frameScores[j] += 10 - prev;
                        //Add next 1 roll
                        if (j < 9) {
                            String nextRollStr = frames[j + 1].substring(0, 1);
                            if (nextRollStr.equals("X")) {
                                frameScores[j] += 10;
                            } else {
                                frameScores[j] += Integer.parseInt(nextRollStr);
                            }
                        } else // j==9  10th frame
                        {
                            String nextRollStr = frames[j].substring(2, 3);
                            if (nextRollStr.equals("X")) {
                                frameScores[j] += 10;
                            } else {
                                frameScores[j] += Integer.parseInt(nextRollStr);
                            }
                            break;
                        }
                    } else {
                        frameScores[j] += Integer.parseInt(digit);
                    }
                }
            }
            int sum = 0;
            for(int score: frameScores)
            {
                sum += score;
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}
