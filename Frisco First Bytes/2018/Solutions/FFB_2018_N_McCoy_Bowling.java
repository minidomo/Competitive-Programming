import java.util.*;
import java.io.*;

public class FFB_2018_N_McCoy_Bowling {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(new File("N.txt"));
        int numOfCases = input.nextInt();
        for (int caseNum = 1; caseNum <= numOfCases; caseNum++) {
            int[] score = new int[10];
            String[] frames = new String[10];         
            for (int i = 0; i < 10; i++) 
                frames[i] = input.next();

            for (int i = 0; i < 9; i++) { //follow these rules for first 9 frames
                if (i != 0) score[i] += score[i-1]; //carry over previous score
                score[i] += getFScore(frames[i]); //include score for this frame                
                if (isStrike(frames[i])) { //u get 2 bonus throws
                    if (isStrike(frames[i+1])) { //if first bonus throw is strike
                        score[i] += 10; //first bonus throw was a strike (+10)
                        if (i==8) //second bonus ball will be pos 2 of frame 10
                            score[i] += get2(frames[i+1]);
                        else
                            score[i] += get1(frames[i+2]); //second bonus ball
                    } else { //first bonus throw not strike.  
                        score[i] += getFScore(frames[i+1]); //Entire next frame is bonus
                    }                    
                } else if (isSpare(frames[i])) { //u get 1 bonus throw
                    score[i] += get1(frames[i+1]);
                }
            }

            //handle frame 10 (position 9 in array)
            score[9] += score[8]; //include prev score
            score[9] += getFScore(frames[9]); //all 3 parts of 10th frame 10

            for (int s : score)
                System.out.print(s + " ");
            System.out.println();            
        }

    }

    public static int getFScore(String s) {
        //Get the combined total for frame s without bonuses
        return get1(s) + get2(s) + get3(s);
    }

    public static int get1(String s) {
        //Get the value of the first ball thrown in frame s
        if (s.charAt(0)=='-') return 0;
        if (s.charAt(0)=='X') return 10;
        return Integer.parseInt(""+s.charAt(0));
    }

    public static int get2(String s) {
        //Get the value of the second ball thrown in frame s
        if (s.length() == 1) return 0;
        if (s.charAt(1)=='-') return 0;        
        if (s.charAt(1)=='/') return 10-get1(s);
        if (s.charAt(1)=='X') return 10; //in frame 10, second symbol can be X
        return Integer.parseInt(""+s.charAt(1));
    }

    public static int get3(String s) {
        //Get the value of the third ball thrown in frame s  (for last frame)
        if (s.length() < 3) return 0;
        if (s.charAt(2)=='-') return 0;
        if (s.charAt(2)=='/') return 10-get2(s);
        if (s.charAt(2)=='X') return 10;
        return Integer.parseInt(""+s.charAt(2));
    }

    public static boolean isStrike(String s) {
        if (s.charAt(0)=='X') return true;
        return false;
    }

    public static boolean isSpare(String s) {
        if (s.charAt(1)=='/') return true;
        return false;
    }   

}
