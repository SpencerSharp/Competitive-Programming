import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF25A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int numNums = Integer.parseInt(f.readLine());
        String[] nums = f.readLine().split(" ");
        int[] evennesses = new int[nums.length];
        int index = 0;
        int numEvens = 0;
        for(String s : nums)
        {
            int n = Integer.parseInt(s);
            int evened = n % 2;
            if(evened==0)
                numEvens++;
            evennesses[index++] = evened;
        }
        if(numEvens == 1)
        {
            for(int i = 1; i <= nums.length; i++)
            {
                if(Integer.parseInt(nums[i-1])%2==0)
                {
                    output = "" + i;
                }
            }
        }
        else
        {
            for(int i = 1; i <= nums.length; i++)
            {
                if(Integer.parseInt(nums[i-1])%2==1)
                {
                    output = "" + i;
                }
            }
        }
        
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}