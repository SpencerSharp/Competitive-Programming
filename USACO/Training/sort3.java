/*
ID: spencer16
LANG: JAVA
PROG: sort3
*/
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class sort3
{
    public static void main(String[] args) throws IOException
    {
        /*
        BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        */
        
        BufferedReader f = new BufferedReader(new FileReader("sort3.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
        
        String output = ""; //Write all output to this string

        //Code here
        int numOfNums = Integer.parseInt(f.readLine());
        int[] nums = new int[numOfNums];
        
        int numOnes = 0;
        int numTwos = 0;
        int numThrees = 0;
        for(int i = 0; i < numOfNums; i++)
        {
            nums[i] = Integer.parseInt(f.readLine());
            if(nums[i]==1)
                numOnes++;
            if(nums[i]==2)
                numTwos++;
            if(nums[i]==3)
                numThrees++;
        }
        //out.println(numOnes);
        int lastSpotInOneZone = numOnes-1;
        int lastSpotInTwoZone = numTwos+numOnes-1;
        int lastSpotInThreeZone = numThrees+numTwos+numOnes-1;
        int[] ones = new int[numOnes];
        int[] twos = new int[numTwos];
        int[] threes = new int[numThrees];
        for(int i = 0; i < numOnes; i++)
            ones[i] = nums[i];
        for(int i = 0; i < numTwos; i++)
            twos[i] = nums[numOnes+i];
        for(int i = 0; i < numThrees; i++)
            threes[i] = nums[numOnes+numTwos+i];
        int loops = 0;
        while(!allGood(ones,twos,threes))
        {
            /*
            String disp = "";
            for(int i = 0; i < ones.length; i++)
                disp += ones[i] + " ";
            disp = disp.substring(0,disp.length()-1);
            disp += ",";
            for(int i = 0; i < twos.length; i++)
                disp += twos[i] + " ";
            disp = disp.substring(0,disp.length()-1);
            disp += ",";
            for(int i = 0; i < threes.length; i++)
                disp += threes[i] + " ";
            out.println(disp);
            */

            int indexOfTwoInOnes = indexOfTwo(ones);
            int indexOfThreeInOnes = indexOfThree(ones);

            int indexOfOneInTwos = indexOfOne(twos);
            int indexOfThreeInTwos = indexOfThree(twos);
            
            int indexOfOneInThrees = indexOfOne(threes);
            int indexOfTwoInThrees = indexOfTwo(threes);
            
            //Try and swap a 1 and 2
            if(indexOfTwoInOnes!=-1 && indexOfOneInTwos !=-1)
            {
                //out.println("SWAPPING 1 AND 2");
                ones[indexOfTwoInOnes] = 1;
                twos[indexOfOneInTwos] = 2;
            }
            //Try and swap a 1 and 3
            else if(indexOfThreeInOnes!=-1 && indexOfOneInThrees!=-1)
            {
                //out.println("SWAPPING 3 AND 1");
                ones[indexOfThreeInOnes] = 1;
                threes[indexOfOneInThrees] = 3;
            }
            //Try and swap a 2 and 3
            else if(indexOfThreeInTwos!=-1&&indexOfTwoInThrees!=-1)
            {
                //out.println("SWAPPING 2 AND 3");
                
                threes[indexOfTwoInThrees] = 3;
                twos[indexOfThreeInTwos] = 2;
            }
            else if(indexOfTwoInOnes!=-1&&indexOfThreeInTwos!=-1)
            {
                //out.println("SWAPPING 2 IN ONES AND 3 IN TWOS");
                
                ones[indexOfTwoInOnes] = 3;
                twos[indexOfThreeInTwos] = 2;
            }
            else if(indexOfThreeInOnes!=-1&&indexOfOneInTwos!=-1)
            {
                //out.println("SWAPPING 3 IN ONES AND 1 IN TWOS");
                
                ones[indexOfThreeInOnes] = 1;
                twos[indexOfOneInTwos] = 3;
            }
            else if(indexOfOneInThrees!=-1&&indexOfThreeInTwos!=-1)
            {
                //out.println("SWAPPING 1 IN THREES AND 3 IN TWOS");
                
                threes[indexOfOneInThrees] = 3;
                twos[indexOfThreeInTwos] = 1;
            }
            
            loops++;
        }
        
        //Code here

        writer.println(loops);
        /*
        writer.println(output);*/
        writer.close();
        System.exit(0);
        
    }
    
    public static int indexOfOne(int[] ray)
    {
        for(int i = 0; i < ray.length; i++)
            if(ray[i]==1)
                return i;
        return -1;
    }
    
    public static int indexOfTwo(int[] ray)
    {
        for(int i = 0; i < ray.length; i++)
            if(ray[i]==2)
                return i;
        return -1;
    }
    
    public static int indexOfThree(int[] ray)
    {
        for(int i = 0; i < ray.length; i++)
            if(ray[i]==3)
                return i;
        return -1;
    }
    
    public static boolean allGood(int[] ones, int[] twos, int[] threes)
    {
        for(int n : ones)
            if(n!=1)
                return false;
        for(int n : twos)
            if(n!=2)
                return false;
        for(int n : threes)
            if(n!=3)
                return false;
        return true;
    }
}
