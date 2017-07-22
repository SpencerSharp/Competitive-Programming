import static java.lang.System.out;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author spencersharp
 */
public class PrimeChecker {
    public static void main(String[] args)
    {
        int max = (int)Math.sqrt(Math.pow(10,12));
        int[] nums = new int[(int)Math.sqrt(Math.pow(10,12))+1];
        HashSet<Long> results = new HashSet<Long>();
        results.add(2l);
        for(int num = 3; num <= max; num+=2)
        {
            if(nums[num]!=-1)
            {
                results.add((long)num);
                for(int num2 = num * 2; num2 <= max; num2 += num)
                {
                    nums[num2] = -1;
                }
            }
        }
    }
    
    public static boolean isPrime(long num)
    {
        boolean isPrime = true;
        
        for(long t = 2; t <= Math.sqrt(num); t++)
        {
            if(num%t==0)
                isPrime = false;
        }
        
        return isPrime;
    }
    
    public static boolean isTPrime(long num)
    {
        boolean isTPrime = true;
        
        for(long t = 2; t < Math.sqrt(num); t++)
        {
            if(num%t==0)
                isTPrime = false;
        }
        
        return isTPrime;
    }
}