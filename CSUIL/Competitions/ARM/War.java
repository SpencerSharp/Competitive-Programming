
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bo
 */
public class War {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("war.dat"));
        int numLoops = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numLoops; i++) {
            String[] line1 = sc.nextLine().split(" ");
            String[] line2 = sc.nextLine().split(" ");
            for(int k = 0; k < line1.length; k++) {
                if(line1[k].equals("J"))
                    line1[k] = "11";
                if(line1[k].equals("Q"))
                    line1[k] = "12";
                if(line1[k].equals("K"))
                    line1[k] = "13";
                if(line1[k].equals("A"))
                    line1[k] = "14";
                
            }
            for(int k = 0; k < line2.length; k++) {
                if(line2[k].equals("J"))
                    line2[k] = "11";
                if(line2[k].equals("Q"))
                    line2[k] = "12";
                if(line2[k].equals("K"))
                    line2[k] = "13";
                if(line2[k].equals("A"))
                    line2[k] = "14";
                
            }
            int score1 = 15;
            int score2 = 15;
            boolean war = false;
            for(int k = 0; k < line1.length; k++) {
                if(Integer.parseInt(line1[k]) > Integer.parseInt(line2[k])) {
                    score1++;
                    score2--;
                    if(war) {
                        score1 += 4;
                        score2 -= 4;
                        war = false;
                    }
                }
                if(Integer.parseInt(line1[k]) < Integer.parseInt(line2[k])) {
                    score1--;
                    score2++;
                    if(war) {
                        score1 -= 4;
                        score2 += 4;
                        war = false;
                    }
                }
                
                if(Integer.parseInt(line1[k]) == Integer.parseInt(line2[k])) {
                    k+= 3;
                    war = true;
                }
                
                
            }
            
            System.out.println(score1 + " " + score2);
        }
    }
}
