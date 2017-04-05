import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;

public class CF405A
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader f = new BufferedReader(new FileReader("/Users/spencersharp/Desktop/input.txt"));
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        String output = ""; //Write all output to this string

        //Code here
        int n = Integer.parseInt(f.readLine());
        String[] nums = f.readLine().split(" ");
        int max = Integer.parseInt(nums[0]);
        for(String num : nums)
            if(Integer.parseInt(num) > max)
                max = Integer.parseInt(num);
        int[] rowCounts = new int[max];
        for(int i = 1; i <= max; i++)
        {
            for(String s : nums)
            {
                if(Integer.parseInt(s)>= i)
                {
                    rowCounts[i-1]++;
                }
            }
        }
        int[] colCounts = new int[n];
        for(int i = 0; i < colCounts.length; i++)
        {
            for(int num : rowCounts)
            {
                if(num >= i+1)
                {
                    colCounts[i]++;
                }
            }
        }
        for(int i = colCounts.length-1; i >= 0; i--)
            output += colCounts[i] + " ";
        
        output = output.substring(0,output.length()-1);
        //Code here

        //out.println(output);
        
        writer.println(output);
        writer.close();
        System.exit(0);
        
    }
}
