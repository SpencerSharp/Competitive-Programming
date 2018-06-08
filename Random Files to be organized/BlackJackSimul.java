
import static java.lang.System.out;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author spencersharp
 */
public class BlackJackSimul {
    public static void main(String[] args)
    {
        int dealerWin = 0;
        for(int i = 0; i < 100000000; i++)
        {
        int[] nums = {1,2,3,4,5,6,7,8,9,10,10,10,10};
        int player1Val = 14;
            int rand = (int)(Math.random()*nums.length);
            int totalAfter = player1Val + nums[rand];
            int dealerTotal = 4;
            if(totalAfter>21)
            {
                dealerWin++;
            }
            else{
                if(totalAfter<=21)
                {
                    while(dealerTotal < 17)
                    {
                        dealerTotal += nums[(int)(Math.random()*nums.length)];
                    }
                    if(dealerTotal <= 21 && dealerTotal > totalAfter)
                    {
                        dealerWin++;
                    }
                }
            }
        }
        
        out.println("Win %:" + (100-((((double)dealerWin))/1000000)));
        dealerWin = 0;
        for(int i = 0; i < 100000000; i++)
        {
            int[] nums = {1,2,3,4,5,6,7,8,9,10,10,10,10};
            int player1Val = 14;
            int dealerTotal = 4;
            while(dealerTotal < 17)
            {
                dealerTotal += nums[(int)(Math.random()*nums.length)];
            }
            if(dealerTotal <= 21 && dealerTotal > player1Val)
            {
                dealerWin++;
            }
        }
        out.println("Win %:" + (100-((((double)dealerWin))/1000000)));
    }
}
