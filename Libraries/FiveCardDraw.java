
import static java.lang.System.out;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author spencersharp
 */
public class FiveCardDraw {
    public static void main(String[] args)
    {
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        String[] suits = {"D","S","H","C"};
        String[] hand1 = new String[5];
        String[] hand2 = new String[5];
        for(int i = 0; i < 5; i++)
        {
            int randN = (int)(Math.random()*nums.length);
            int randS = (int)(Math.random()*suits.length);
            hand1[i] = ""+nums[randN] + "" + suits[randS];
        }
        for(String s : hand1)
            out.print(s + " ");
        out.println();
        for(int i = 0; i < 5; i++)
        {
            int randN = (int)(Math.random()*nums.length);
            int randS = (int)(Math.random()*suits.length);
            hand2[i] = ""+nums[randN] + "" + suits[randS];

        }
        for(String s : hand2)
            out.print(s + " ");
        out.println();
        out.println("P1 which cards u wanna throw out");
        Scanner l = new Scanner(System.in);
        String choice = l.nextLine();
        for(int i = 0; i < choice.length(); i++)
        {
            int randN = (int)(Math.random()*nums.length);
            int randS = (int)(Math.random()*suits.length);
            hand1[Integer.parseInt(""+choice.charAt(i))] = nums[randN] + "" + suits[randS];
        }
        out.println("P2 which cards u wanna throw out");
        l = new Scanner(System.in);
        choice = l.nextLine();
        for(int i = 0; i < choice.length(); i++)
        {
            int randN = (int)(Math.random()*nums.length);
            int randS = (int)(Math.random()*suits.length);
            hand2[Integer.parseInt(""+choice.charAt(i))] = nums[randN] + "" + suits[randS];
        }
        for(String s : hand1)
            out.print(s + " ");
        out.println();
        for(String s : hand2)
            out.print(s + " ");
        out.println();
    }
}
